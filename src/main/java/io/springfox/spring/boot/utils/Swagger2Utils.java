/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.springfox.spring.boot.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import io.springfox.spring.boot.Swagger2WebMvcProperties;
import io.springfox.spring.boot.model.DocketInfo;
import io.springfox.spring.boot.model.GlobalOperationParameter;
import io.springfox.spring.boot.model.GlobalResponseMessage;
import io.springfox.spring.boot.model.GlobalResponseMessageBody;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;

/**
 * Utility for building Springfox {@link Docket} instances and their supporting objects (API
 * info, security schemes/contexts, global parameters and global response messages) from the
 * bound {@link Swagger2WebMvcProperties}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class Swagger2Utils {

	/**
	 * Builds the {@link ApiInfo} from the global Swagger properties.
	 * @param swaggerProperties the Swagger properties
	 * @return the built API info
	 */
	public static ApiInfo apiInfo(Swagger2WebMvcProperties swaggerProperties) {
 		return new ApiInfoBuilder()
				.title(swaggerProperties.getTitle())
				.description(swaggerProperties.getDescription())
				.version(swaggerProperties.getVersion())
				.license(swaggerProperties.getLicense())
				.licenseUrl(swaggerProperties.getLicenseUrl())
				.contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
				.termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
				.build();
	}
	
	/**
	 * Builds the {@link ApiInfo} for a documentation group, falling back to the global
	 * Swagger properties when the group does not specify a value.
	 * @param docketInfo the group configuration
	 * @param swaggerProperties the global Swagger properties
	 * @return the built API info
	 */
	public static ApiInfo apiInfo(DocketInfo docketInfo, Swagger2WebMvcProperties swaggerProperties) {
 		return new ApiInfoBuilder()
				.title(StringUtils.hasText(docketInfo.getTitle()) ? swaggerProperties.getTitle() : docketInfo.getTitle())
				.description(StringUtils.hasText(docketInfo.getDescription()) ? swaggerProperties.getDescription() : docketInfo.getDescription())
				.version(StringUtils.hasText(docketInfo.getVersion()) ? swaggerProperties.getVersion() : docketInfo.getVersion())
				.license(StringUtils.hasText(docketInfo.getLicense()) ? swaggerProperties.getLicense() : docketInfo.getLicense())
				.licenseUrl(StringUtils.hasText(docketInfo.getLicenseUrl()) ? swaggerProperties.getLicenseUrl() : docketInfo.getLicenseUrl())
				.contact(new Contact(
						StringUtils.hasText(docketInfo.getContact().getName()) ? swaggerProperties.getContact().getName() : docketInfo.getContact().getName(),
						StringUtils.hasText(docketInfo.getContact().getUrl()) ? swaggerProperties.getContact().getUrl() : docketInfo.getContact().getUrl(),
						StringUtils.hasText(docketInfo.getContact().getEmail()) ? swaggerProperties.getContact().getEmail() : docketInfo.getContact().getEmail()))
				.termsOfServiceUrl(
						StringUtils.hasText(docketInfo.getTermsOfServiceUrl()) ? swaggerProperties.getTermsOfServiceUrl() : docketInfo.getTermsOfServiceUrl())
				.build();
	}
	
	/**
	 * Builds the default {@link Docket} from the global Swagger properties.
	 * @param swaggerProperties the Swagger properties
	 * @return the default docket
	 */
	public static Docket defaultDocket(Swagger2WebMvcProperties swaggerProperties) {
		
		Docket docketForBuilder = new Docket(DocumentationType.SWAGGER_2)
				.host(swaggerProperties.getHost())
				.apiInfo(apiInfo(swaggerProperties))
				.securityContexts(Collections.singletonList(securityContext(swaggerProperties)))
				.globalOperationParameters(buildGlobalOperationParametersFromSwagger2WebMvcProperties( swaggerProperties.getGlobalOperationParameters()));

		switch (swaggerProperties.getAuthorization().getType()) {
			case APIKEY:{
				docketForBuilder.securitySchemes(Collections.singletonList(apiKey(swaggerProperties)));
			};break;
			case BASICAUTH:{
				docketForBuilder.securitySchemes(Collections.singletonList(basicAuth(swaggerProperties)));
			};break;
			default:{
				
			};break;
		}

		// Global response messages
		if (!swaggerProperties.isApplyDefaultResponseMessages()) {
			buildGlobalResponseMessage(swaggerProperties, docketForBuilder);
		}

		// RequestHandlerSelectors.basePackage(basePackage)
		// PathSelectors.ant(antPattern)

		Docket docket = docketForBuilder.select()
				.apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
				.paths(StringUtils.hasText(swaggerProperties.getBasePathPattern()) ? PathSelectors.ant(swaggerProperties.getBasePathPattern()) : PathSelectors.any())
				.build();

		/* ignoredParameterTypes **/
		Class<?>[] array = new Class[swaggerProperties.getIgnoredParameterTypes().size()];
		Class<?>[] ignoredParameterTypes = swaggerProperties.getIgnoredParameterTypes().toArray(array);
		docket.ignoredParameterTypes(ignoredParameterTypes)
				.enableUrlTemplating(swaggerProperties.isEnableUrlTemplating())
				.forCodeGeneration(swaggerProperties.isForCodeGen());

		return docket;
		
	}
	
	/**
	 * Builds a {@link Docket} for a documentation group, merging the group's parameters with
	 * the global parameters.
	 * @param docketInfo the group configuration
	 * @param swaggerProperties the global Swagger properties
	 * @return the group docket
	 */
	public static Docket groupDocket(DocketInfo docketInfo, Swagger2WebMvcProperties swaggerProperties) {

		Docket docketForBuilder = new Docket(DocumentationType.SWAGGER_2)
				.host(swaggerProperties.getHost())
				.apiInfo(apiInfo(docketInfo, swaggerProperties))
				.securityContexts(Collections.singletonList(securityContext(swaggerProperties)))
				.globalOperationParameters(assemblyGlobalOperationParameters(swaggerProperties.getGlobalOperationParameters(), docketInfo.getGlobalOperationParameters()));

		switch (swaggerProperties.getAuthorization().getType()) {
			case APIKEY:{
				docketForBuilder.securitySchemes(Collections.singletonList(apiKey(swaggerProperties)));
			};break;
			case BASICAUTH:{
				docketForBuilder.securitySchemes(Collections.singletonList(basicAuth(swaggerProperties)));
			};break;
			default:{
				
			};break;
		}

		// Global response messages
		if (!swaggerProperties.isApplyDefaultResponseMessages()) {
			buildGlobalResponseMessage(swaggerProperties, docketForBuilder);
		}

		Docket docket = docketForBuilder.groupName(docketInfo.getName()).select()
				.apis(RequestHandlerSelectors.basePackage(docketInfo.getBasePackage()))
				.paths(StringUtils.hasText(docketInfo.getBasePathPattern()) ? PathSelectors.ant(docketInfo.getBasePathPattern()) : PathSelectors.any())
				.build();

		/* ignoredParameterTypes **/
		Class<?>[] array = new Class[docketInfo.getIgnoredParameterTypes().size()];
		Class<?>[] ignoredParameterTypes = docketInfo.getIgnoredParameterTypes().toArray(array);
		docket.ignoredParameterTypes(ignoredParameterTypes)
				.enableUrlTemplating(docketInfo.isEnableUrlTemplating())
				.forCodeGeneration(docketInfo.isForCodeGen());
		
		return docket;
	}
	

	/**
	 * Builds the {@link ApiKey} security scheme from the Swagger properties.
	 * @param swaggerProperties the Swagger properties
	 * @return the API-key security scheme
	 */
	public static ApiKey apiKey(Swagger2WebMvcProperties swaggerProperties) {
		return new ApiKey(swaggerProperties.getAuthorization().getName(),
				swaggerProperties.getAuthorization().getKeyName(), ApiKeyVehicle.HEADER.getValue());
	}

	/**
	 * Builds the {@link BasicAuth} security scheme from the Swagger properties.
	 * @param swaggerProperties the Swagger properties
	 * @return the basic-auth security scheme
	 */
	public static BasicAuth basicAuth(Swagger2WebMvcProperties swaggerProperties) {
		return new BasicAuth(swaggerProperties.getAuthorization().getName());
	}

	/**
	 * Builds the global {@link SecurityContext}, enabling authorization on URLs matching the
	 * configured regular expression (defaults to {@code ^.*$}, i.e. all URLs), and binding
	 * the security references.
	 * @param swaggerProperties the Swagger properties
	 * @return the security context
	 */
	public static SecurityContext securityContext(Swagger2WebMvcProperties swaggerProperties) {
		return SecurityContext.builder().securityReferences(defaultAuth(swaggerProperties))
				.forPaths(PathSelectors.regex(swaggerProperties.getAuthorization().getAuthRegex())).build();
	}

	/**
	 * Builds the default global security references. The {@link SecurityReference} reference
	 * name must match the {@link ApiKey} name for global authorization to take effect.
	 * @param swaggerProperties the Swagger properties
	 * @return the default security references
	 */
	public static List<SecurityReference> defaultAuth(Swagger2WebMvcProperties swaggerProperties) {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Collections.singletonList(SecurityReference.builder()
				.reference(swaggerProperties.getAuthorization().getName()).scopes(authorizationScopes).build());
	}

	/**
	 * Converts the configured global operation parameters into Springfox {@link Parameter}
	 * objects.
	 * @param globalOperationParameters the configured global parameters
	 * @return the list of Springfox parameters (never {@code null})
	 */
	public static List<Parameter> buildGlobalOperationParametersFromSwagger2WebMvcProperties(
			List<GlobalOperationParameter> globalOperationParameters) {
		List<Parameter> parameters = new ArrayList<Parameter>();

		if (Objects.isNull(globalOperationParameters)) {
			return parameters;
		}
		for (GlobalOperationParameter globalOperationParameter : globalOperationParameters) {
			parameters.add(new ParameterBuilder().name(globalOperationParameter.getName())
					.description(globalOperationParameter.getDescription())
					.defaultValue(globalOperationParameter.getDefaultValue())
					.allowEmptyValue(globalOperationParameter.isAllowEmptyValue())
					.scalarExample(globalOperationParameter.getScalarExample())
					.modelRef(new ModelRef(globalOperationParameter.getModelRef()))
					.parameterType(globalOperationParameter.getParameterType())
					.pattern(globalOperationParameter.getPattern())
					.hidden(globalOperationParameter.isHidden())
					.required(globalOperationParameter.isRequired())
					.build());
		}
		return parameters;
	}

	/**
	 * Merges the global parameters with the group parameters; group parameters override
	 * global parameters with the same name.
	 * @param globalOperationParameters the global parameters
	 * @param docketOperationParameters the current group parameters
	 * @return the merged list of Springfox parameters
	 */
	public static List<Parameter> assemblyGlobalOperationParameters(List<GlobalOperationParameter> globalOperationParameters,
			List<GlobalOperationParameter> docketOperationParameters) {

		if (Objects.isNull(docketOperationParameters) || docketOperationParameters.isEmpty()) {
			return buildGlobalOperationParametersFromSwagger2WebMvcProperties(globalOperationParameters);
		}

		Set<String> docketNames = docketOperationParameters.stream().map(GlobalOperationParameter::getName)
				.collect(Collectors.toSet());

		List<GlobalOperationParameter> resultOperationParameters = new ArrayList<GlobalOperationParameter>();

		if (Objects.nonNull(globalOperationParameters)) {
			for (GlobalOperationParameter parameter : globalOperationParameters) {
				if (!docketNames.contains(parameter.getName())) {
					resultOperationParameters.add(parameter);
				}
			}
		}

		resultOperationParameters.addAll(docketOperationParameters);
		return buildGlobalOperationParametersFromSwagger2WebMvcProperties(resultOperationParameters);
	}

	/**
	 * Sets the global response messages on the given docket builder for the HTTP methods
	 * POST, GET, PUT, PATCH, DELETE, HEAD, OPTIONS and TRACE.
	 * @param swaggerProperties the Swagger properties
	 * @param docketForBuilder the Swagger docket builder
	 */
	public static void buildGlobalResponseMessage(Swagger2WebMvcProperties swaggerProperties, Docket docketForBuilder) {

		GlobalResponseMessage globalResponseMessages = swaggerProperties.getGlobalResponseMessage();

		/* Response message bodies for POST, GET, PUT, PATCH, DELETE, HEAD, OPTIONS, TRACE **/
		List<ResponseMessage> postResponseMessages = getResponseMessageList(globalResponseMessages.getPost());
		List<ResponseMessage> getResponseMessages = getResponseMessageList(globalResponseMessages.getGet());
		List<ResponseMessage> putResponseMessages = getResponseMessageList(globalResponseMessages.getPut());
		List<ResponseMessage> patchResponseMessages = getResponseMessageList(globalResponseMessages.getPatch());
		List<ResponseMessage> deleteResponseMessages = getResponseMessageList(globalResponseMessages.getDelete());
		List<ResponseMessage> headResponseMessages = getResponseMessageList(globalResponseMessages.getHead());
		List<ResponseMessage> optionsResponseMessages = getResponseMessageList(globalResponseMessages.getOptions());
		List<ResponseMessage> trackResponseMessages = getResponseMessageList(globalResponseMessages.getTrace());

		docketForBuilder.useDefaultResponseMessages(swaggerProperties.isApplyDefaultResponseMessages())
				.globalResponseMessage(RequestMethod.POST, postResponseMessages)
				.globalResponseMessage(RequestMethod.GET, getResponseMessages)
				.globalResponseMessage(RequestMethod.PUT, putResponseMessages)
				.globalResponseMessage(RequestMethod.PATCH, patchResponseMessages)
				.globalResponseMessage(RequestMethod.DELETE, deleteResponseMessages)
				.globalResponseMessage(RequestMethod.HEAD, headResponseMessages)
				.globalResponseMessage(RequestMethod.OPTIONS, optionsResponseMessages)
				.globalResponseMessage(RequestMethod.TRACE, trackResponseMessages);
	}

	/**
	 * Converts the configured response message bodies into Springfox {@link ResponseMessage}
	 * objects.
	 * @param globalResponseMessageBodyList the configured response message bodies
	 * @return the list of Springfox response messages
	 */
	public static List<ResponseMessage> getResponseMessageList(
			List<GlobalResponseMessageBody> globalResponseMessageBodyList) {
		List<ResponseMessage> responseMessages = new ArrayList<>();
		for (GlobalResponseMessageBody globalResponseMessageBody : globalResponseMessageBodyList) {
			ResponseMessageBuilder responseMessageBuilder = new ResponseMessageBuilder();
			responseMessageBuilder.code(globalResponseMessageBody.getCode())
					.message(globalResponseMessageBody.getMessage());

			if (!StringUtils.isEmpty(globalResponseMessageBody.getModelRef())) {
				responseMessageBuilder.responseModel(new ModelRef(globalResponseMessageBody.getModelRef()));
			}
			responseMessages.add(responseMessageBuilder.build());
		}

		return responseMessages;
	}

	
}

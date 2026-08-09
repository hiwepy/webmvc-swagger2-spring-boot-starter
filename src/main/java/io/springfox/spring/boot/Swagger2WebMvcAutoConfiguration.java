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
package io.springfox.spring.boot;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.springfox.spring.boot.model.DocketInfo;
import io.springfox.spring.boot.utils.Swagger2Utils;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Spring Boot auto-configuration for Swagger2 in Spring WebMVC applications. <p>Activated when
 * {@code swagger.enabled=true}, it registers the Swagger UI resource configurer, the UI
 * configuration bean and the {@link Docket} documentation groups. Most of the implementation
 * is adapted from the spring-boot-starter-swagger project.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = Swagger2WebMvcProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties({ Swagger2WebMvcProperties.class })
@EnableSwagger2WebMvc
@Import({ BeanValidatorPluginsConfiguration.class })
public class Swagger2WebMvcAutoConfiguration implements BeanFactoryAware {

	private BeanFactory beanFactory;

	/**
	 * Registers the Swagger UI resource and view controller configurer.
	 * @return a new {@link Swagger2UiWebMvcConfigurer}
	 */
	@Bean
	public Swagger2UiWebMvcConfigurer swagger2UiWebMvcConfigurer() {
		return new Swagger2UiWebMvcConfigurer();
	}

	/*
	 * @Primary
	 *
	 * @Bean public ServiceModelToSwagger2Mapper ServiceModelToSwagger2Mapper() {
	 * return new ExtendServiceModelToSwagger2MapperImpl(); }
	 */

	/**
	 * Builds the Swagger UI configuration from the bound properties.
	 * @param swaggerProperties the Swagger properties
	 * @return a new {@link UiConfiguration}
	 */
	@Bean
	public UiConfiguration uiConfiguration(Swagger2WebMvcProperties swaggerProperties) {
		return UiConfigurationBuilder.builder()
				.deepLinking(swaggerProperties.getUiConfig().getDeepLinking())
				.defaultModelExpandDepth(swaggerProperties.getUiConfig().getDefaultModelExpandDepth())
				.defaultModelRendering(swaggerProperties.getUiConfig().getDefaultModelRendering())
				.defaultModelsExpandDepth(swaggerProperties.getUiConfig().getDefaultModelsExpandDepth())
				.displayOperationId(swaggerProperties.getUiConfig().getDisplayOperationId())
				.displayRequestDuration(swaggerProperties.getUiConfig().getDisplayRequestDuration())
				.docExpansion(swaggerProperties.getUiConfig().getDocExpansion())
				.maxDisplayedTags(swaggerProperties.getUiConfig().getMaxDisplayedTags())
				.operationsSorter(swaggerProperties.getUiConfig().getOperationsSorter())
				.showExtensions(swaggerProperties.getUiConfig().getShowExtensions())
				.tagsSorter(swaggerProperties.getUiConfig().getTagsSorter())
				.validatorUrl(swaggerProperties.getUiConfig().getValidatorUrl())
				.build();
	}

	
	
	/**
	 * Builds the default {@link Docket} together with one {@link Docket} per configured group,
	 * registering each as a singleton in the bean factory.
	 * @param swaggerProperties the Swagger properties
	 * @return the list of created dockets (default first, then groups)
	 */
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnBean(UiConfiguration.class)
	@ConditionalOnProperty(prefix = Swagger2WebMvcProperties.PREFIX, name = "enabled", matchIfMissing = true)
	public List<Docket> createRestApi(Swagger2WebMvcProperties swaggerProperties) {
		ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
		List<Docket> docketList = new LinkedList<>();

		Docket defaultDocket = Swagger2Utils.defaultDocket(swaggerProperties);
		
		configurableBeanFactory.registerSingleton("defaultDocket", defaultDocket);
		docketList.add(defaultDocket);

		// Create one docket per group
		for (DocketInfo docketInfo : swaggerProperties.getGroups()) {
			
			String groupName = String.format("%sDocket", docketInfo.getName());
			
			Docket groupDocket = Swagger2Utils.groupDocket(docketInfo, swaggerProperties);
			
			configurableBeanFactory.registerSingleton(groupName, groupDocket);
			docketList.add(groupDocket);
			
		}
		
		return docketList;
	}

	/**
	 * Callback that supplies the owning bean factory.
	 * @param beanFactory the owning bean factory
	 * @throws BeansException in case of errors
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}

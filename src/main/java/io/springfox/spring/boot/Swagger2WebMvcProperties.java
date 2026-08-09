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

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import io.springfox.spring.boot.model.Authorization;
import io.springfox.spring.boot.model.Contact;
import io.springfox.spring.boot.model.DocketInfo;
import io.springfox.spring.boot.model.GlobalOperationParameter;
import io.springfox.spring.boot.model.GlobalResponseMessage;
import io.springfox.spring.boot.model.UiConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Configuration properties for the Swagger2 WebMVC starter. <p>Binds the {@code swagger}
 * prefix and exposes the documentation title, description, version, license, contact,
 * base package, groups, global parameters, response messages and authorization settings.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@ConfigurationProperties(Swagger2WebMvcProperties.PREFIX)
@Getter
@Setter
@ToString
public class Swagger2WebMvcProperties {

	public static final String PREFIX = "swagger";

	/**
	 * Whether Swagger is enabled.
	 **/
	private boolean enabled;
	/**
	 * When {@code true} it enables rfc6570 url templates.
	 */
	private boolean enableUrlTemplating = false;
	/**
	 * Set this to {@code true} in order to make the documentation code generation friendly.
	 *
	 * {@code true}|{@code false} determines the naming strategy used.
	 */
	private boolean forCodeGen = false;
	/**
	 * Documentation title.
	 **/
	private String title = "";
	/**
	 * Documentation description.
	 **/
	private String description = "";
	/**
	 * Documentation version.
	 **/
	private String version = "";
	/**
	 * License name.
	 **/
	private String license = "";
	/**
	 * License URL.
	 **/
	private String licenseUrl = "";
	/**
	 * Terms of service URL.
	 **/
	private String termsOfServiceUrl = "";

	/**
	 * Parameter types to be ignored by Swagger.
	 **/
	private List<Class<?>> ignoredParameterTypes = new ArrayList<>();

	@NestedConfigurationProperty
	private Contact contact = new Contact();

	/**
	 * Base package scanned by Swagger for API endpoints.
	 **/
	private String basePackage = "";

	/**
	 * Ant expression of URL paths Swagger will resolve.
	 **/
	private String basePathPattern = "";

	/**
	 * Host information.
	 **/
	private String host = "";

	/**
	 * Documentation groups.
	 **/
	@NestedConfigurationProperty
	private List<DocketInfo> groups = new ArrayList<DocketInfo>();

	/**
	 * Global operation parameters.
	 **/
	private List<GlobalOperationParameter> globalOperationParameters;

	/**
	 * Swagger UI configuration.
	 **/
	@NestedConfigurationProperty
	private UiConfig uiConfig = new UiConfig();

	/**
	 * Whether to use the default predefined response messages; defaults to {@code true}.
	 **/
	private boolean applyDefaultResponseMessages = true;

	/**
	 * Global response messages.
	 **/
	@NestedConfigurationProperty
	private GlobalResponseMessage globalResponseMessage;

	/**
	 * Global authorization configuration.
	 **/
	@NestedConfigurationProperty
	private Authorization authorization = new Authorization();

}

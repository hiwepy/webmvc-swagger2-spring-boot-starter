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

/**
 * Configuration properties for the Swagger2 WebMVC starter. <p>Binds the {@code swagger}
 * prefix and exposes the documentation title, description, version, license, contact,
 * base package, groups, global parameters, response messages and authorization settings.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@ConfigurationProperties(Swagger2WebMvcProperties.PREFIX)
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnableUrlTemplating() {
		return enableUrlTemplating;
	}

	public void setEnableUrlTemplating(boolean enableUrlTemplating) {
		this.enableUrlTemplating = enableUrlTemplating;
	}

	public boolean isForCodeGen() {
		return forCodeGen;
	}

	public void setForCodeGen(boolean forCodeGen) {
		this.forCodeGen = forCodeGen;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}

	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}

	public List<Class<?>> getIgnoredParameterTypes() {
		return ignoredParameterTypes;
	}

	public void setIgnoredParameterTypes(List<Class<?>> ignoredParameterTypes) {
		this.ignoredParameterTypes = ignoredParameterTypes;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getBasePathPattern() {
		return basePathPattern;
	}

	public void setBasePathPattern(String basePathPattern) {
		this.basePathPattern = basePathPattern;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<DocketInfo> getGroups() {
		return groups;
	}

	public void setGroups(List<DocketInfo> groups) {
		this.groups = groups;
	}

	public List<GlobalOperationParameter> getGlobalOperationParameters() {
		return globalOperationParameters;
	}

	public void setGlobalOperationParameters(List<GlobalOperationParameter> globalOperationParameters) {
		this.globalOperationParameters = globalOperationParameters;
	}

	public UiConfig getUiConfig() {
		return uiConfig;
	}

	public void setUiConfig(UiConfig uiConfig) {
		this.uiConfig = uiConfig;
	}

	public boolean isApplyDefaultResponseMessages() {
		return applyDefaultResponseMessages;
	}

	public void setApplyDefaultResponseMessages(boolean applyDefaultResponseMessages) {
		this.applyDefaultResponseMessages = applyDefaultResponseMessages;
	}

	public GlobalResponseMessage getGlobalResponseMessage() {
		return globalResponseMessage;
	}

	public void setGlobalResponseMessage(GlobalResponseMessage globalResponseMessage) {
		this.globalResponseMessage = globalResponseMessage;
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	@Override
	public String toString() {
		return "Swagger2WebMvcProperties{enabled=" + enabled + ", title='" + title + "', basePackage='" + basePackage + "'}";
	}

}

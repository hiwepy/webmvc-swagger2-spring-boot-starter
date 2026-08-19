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
package io.springfox.spring.boot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for a single Swagger documentation group.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class DocketInfo {

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
	 * Group name.
	 **/
	private String name = "";
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

	private Contact contact = new Contact();

	/**
	 * Base package scanned by Swagger for this group.
	 **/
	private String basePackage = "";

	/**
	 * Ant expression of URL paths Swagger will resolve for this group.
	 **/
	private String basePathPattern = "";

	private List<GlobalOperationParameter> globalOperationParameters;
	/**
	 * Parameter types to be ignored by Swagger for this group.
	 **/
	private List<Class<?>> ignoredParameterTypes = new ArrayList<>();

	/**
	 * Returns the enable url templating.
	 *
	 * @return the enable url templating
	 */
	public boolean isEnableUrlTemplating() {
		return enableUrlTemplating;
	}

	/**
	 * Sets the enable url templating.
	 *
	 * @param enableUrlTemplating the enable url templating
	 */
	public void setEnableUrlTemplating(boolean enableUrlTemplating) {
		this.enableUrlTemplating = enableUrlTemplating;
	}

	/**
	 * Returns the for code gen.
	 *
	 * @return the for code gen
	 */
	public boolean isForCodeGen() {
		return forCodeGen;
	}

	/**
	 * Sets the for code gen.
	 *
	 * @param forCodeGen the for code gen
	 */
	public void setForCodeGen(boolean forCodeGen) {
		this.forCodeGen = forCodeGen;
	}

	/**
	 * Returns the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Returns the license.
	 *
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * Sets the license.
	 *
	 * @param license the license
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * Returns the license url.
	 *
	 * @return the license url
	 */
	public String getLicenseUrl() {
		return licenseUrl;
	}

	/**
	 * Sets the license url.
	 *
	 * @param licenseUrl the license url
	 */
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	/**
	 * Returns the terms of service url.
	 *
	 * @return the terms of service url
	 */
	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}

	/**
	 * Sets the terms of service url.
	 *
	 * @param termsOfServiceUrl the terms of service url
	 */
	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}

	/**
	 * Returns the contact.
	 *
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * Returns the base package.
	 *
	 * @return the base package
	 */
	public String getBasePackage() {
		return basePackage;
	}

	/**
	 * Sets the base package.
	 *
	 * @param basePackage the base package
	 */
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	/**
	 * Returns the base path pattern.
	 *
	 * @return the base path pattern
	 */
	public String getBasePathPattern() {
		return basePathPattern;
	}

	/**
	 * Sets the base path pattern.
	 *
	 * @param basePathPattern the base path pattern
	 */
	public void setBasePathPattern(String basePathPattern) {
		this.basePathPattern = basePathPattern;
	}

	/**
	 * Returns the global operation parameters.
	 *
	 * @return the global operation parameters
	 */
	public List<GlobalOperationParameter> getGlobalOperationParameters() {
		return globalOperationParameters;
	}

	/**
	 * Sets the global operation parameters.
	 *
	 * @param globalOperationParameters the global operation parameters
	 */
	public void setGlobalOperationParameters(List<GlobalOperationParameter> globalOperationParameters) {
		this.globalOperationParameters = globalOperationParameters;
	}

	/**
	 * Returns the ignored parameter types.
	 *
	 * @return the ignored parameter types
	 */
	public List<Class<?>> getIgnoredParameterTypes() {
		return ignoredParameterTypes;
	}

	/**
	 * Sets the ignored parameter types.
	 *
	 * @param ignoredParameterTypes the ignored parameter types
	 */
	public void setIgnoredParameterTypes(List<Class<?>> ignoredParameterTypes) {
		this.ignoredParameterTypes = ignoredParameterTypes;
	}

	@Override
	/**
	 * to String.
	 *
	 * @return the result
	 */
	public String toString() {
		return "DocketInfo{name='" + name + "', title='" + title + "', basePackage='" + basePackage + "'}";
	}

}

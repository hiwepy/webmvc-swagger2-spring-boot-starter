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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<GlobalOperationParameter> getGlobalOperationParameters() {
		return globalOperationParameters;
	}

	public void setGlobalOperationParameters(List<GlobalOperationParameter> globalOperationParameters) {
		this.globalOperationParameters = globalOperationParameters;
	}

	public List<Class<?>> getIgnoredParameterTypes() {
		return ignoredParameterTypes;
	}

	public void setIgnoredParameterTypes(List<Class<?>> ignoredParameterTypes) {
		this.ignoredParameterTypes = ignoredParameterTypes;
	}

	@Override
	public String toString() {
		return "DocketInfo{name='" + name + "', title='" + title + "', basePackage='" + basePackage + "'}";
	}

}

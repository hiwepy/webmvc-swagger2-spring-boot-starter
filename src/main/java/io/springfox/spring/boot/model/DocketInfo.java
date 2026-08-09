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

import lombok.Data;

/**
 * Configuration for a single Swagger documentation group.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Data
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

}
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

/**
 * Definition of a global Swagger operation parameter.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class GlobalOperationParameter {

	/**
	 * Parameter name.
	 **/
	private String name;

	/**
	 * Parameter description.
	 **/
	private String description;

	/**
	 * Default value of the parameter.
	 **/
	private String defaultValue;

	/**
	 * Model reference describing the parameter type.
	 **/
	private String modelRef;

	/**
	 * Where the parameter is located: {@code header}, {@code query}, {@code path},
	 * {@code body} or {@code form}.
	 **/
	private String parameterType;

	/**
	 * Whether the parameter is required.
	 **/
	private boolean required;

	/**
	 * Whether the parameter is hidden.
	 **/
	private boolean hidden;

	/**
	 * Parameter pattern (e.g. a regular expression).
	 **/
	private String pattern;

	/**
	 * Whether the parameter allows an empty value.
	 **/
	private boolean allowEmptyValue;

	/**
	 * Example scalar value for the parameter.
	 **/
	private Object scalarExample;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getModelRef() {
		return modelRef;
	}

	public void setModelRef(String modelRef) {
		this.modelRef = modelRef;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public boolean isAllowEmptyValue() {
		return allowEmptyValue;
	}

	public void setAllowEmptyValue(boolean allowEmptyValue) {
		this.allowEmptyValue = allowEmptyValue;
	}

	public Object getScalarExample() {
		return scalarExample;
	}

	public void setScalarExample(Object scalarExample) {
		this.scalarExample = scalarExample;
	}

	@Override
	public String toString() {
		return "GlobalOperationParameter{name='" + name + "', description='" + description + "', modelRef='" + modelRef + "'}";
	}

}

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
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
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
	 * Returns the default value.
	 *
	 * @return the default value
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the default value.
	 *
	 * @param defaultValue the default value
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * Returns the model ref.
	 *
	 * @return the model ref
	 */
	public String getModelRef() {
		return modelRef;
	}

	/**
	 * Sets the model ref.
	 *
	 * @param modelRef the model ref
	 */
	public void setModelRef(String modelRef) {
		this.modelRef = modelRef;
	}

	/**
	 * Returns the parameter type.
	 *
	 * @return the parameter type
	 */
	public String getParameterType() {
		return parameterType;
	}

	/**
	 * Sets the parameter type.
	 *
	 * @param parameterType the parameter type
	 */
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	/**
	 * Returns the required.
	 *
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * Sets the required.
	 *
	 * @param required the required
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * Returns the hidden.
	 *
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * Sets the hidden.
	 *
	 * @param hidden the hidden
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * Returns the pattern.
	 *
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * Sets the pattern.
	 *
	 * @param pattern the pattern
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * Returns the allow empty value.
	 *
	 * @return the allow empty value
	 */
	public boolean isAllowEmptyValue() {
		return allowEmptyValue;
	}

	/**
	 * Sets the allow empty value.
	 *
	 * @param allowEmptyValue the allow empty value
	 */
	public void setAllowEmptyValue(boolean allowEmptyValue) {
		this.allowEmptyValue = allowEmptyValue;
	}

	/**
	 * Returns the scalar example.
	 *
	 * @return the scalar example
	 */
	public Object getScalarExample() {
		return scalarExample;
	}

	/**
	 * Sets the scalar example.
	 *
	 * @param scalarExample the scalar example
	 */
	public void setScalarExample(Object scalarExample) {
		this.scalarExample = scalarExample;
	}

	@Override
	/**
	 * to String.
	 *
	 * @return the result
	 */
	public String toString() {
		return "GlobalOperationParameter{name='" + name + "', description='" + description + "', modelRef='" + modelRef + "'}";
	}

}

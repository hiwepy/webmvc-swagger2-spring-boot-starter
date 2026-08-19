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
 * Global Swagger authorization configuration. <p>Configures one of the supported
 * {@code securitySchemes} types (ApiKey, BasicAuth or None).</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class Authorization {

	/**
	 * Authorization scheme id; matches the {@code SecurityReferences} id.
	 */
	private String name = "X-Authorization";

	/**
	 * Authorization scheme: one of {@code ApiKey}, {@code BasicAuth} or {@code None};
	 * defaults to {@code ApiKey}.
	 */
	private AuthorizationTypeEnum type = AuthorizationTypeEnum.APIKEY;

	/**
	 * Name of the header parameter that carries the authorization token.
	 */
	private String keyName = "token";

	/**
	 * Regular expression of URLs for which authorization is enabled.
	 */
	private String authRegex = "^.*$";

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
	 * Returns the type.
	 *
	 * @return the type
	 */
	public AuthorizationTypeEnum getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type
	 */
	public void setType(AuthorizationTypeEnum type) {
		this.type = type;
	}

	/**
	 * Returns the key name.
	 *
	 * @return the key name
	 */
	public String getKeyName() {
		return keyName;
	}

	/**
	 * Sets the key name.
	 *
	 * @param keyName the key name
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	/**
	 * Returns the auth regex.
	 *
	 * @return the auth regex
	 */
	public String getAuthRegex() {
		return authRegex;
	}

	/**
	 * Sets the auth regex.
	 *
	 * @param authRegex the auth regex
	 */
	public void setAuthRegex(String authRegex) {
		this.authRegex = authRegex;
	}

	@Override
	/**
	 * to String.
	 *
	 * @return the result
	 */
	public String toString() {
		return "Authorization{name='" + name + "', type=" + type + ", keyName='" + keyName + "', authRegex='" + authRegex + "'}";
	}

}

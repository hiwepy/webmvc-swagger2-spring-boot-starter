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
 * @author [@Loong Wan](https://github.com/loong10k)
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthorizationTypeEnum getType() {
		return type;
	}

	public void setType(AuthorizationTypeEnum type) {
		this.type = type;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getAuthRegex() {
		return authRegex;
	}

	public void setAuthRegex(String authRegex) {
		this.authRegex = authRegex;
	}

	@Override
	public String toString() {
		return "Authorization{name='" + name + "', type=" + type + ", keyName='" + keyName + "', authRegex='" + authRegex + "'}";
	}

}

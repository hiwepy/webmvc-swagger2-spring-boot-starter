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

import java.util.NoSuchElementException;

/**
 * Swagger authorization scheme type. <p>One of {@code ApiKey}, {@code BasicAuth} or
 * {@code None}; defaults to {@code ApiKey}.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public enum AuthorizationTypeEnum {

	/** API-key based authorization. */
	APIKEY("ApiKey"),
	/** HTTP basic authentication. */
	BASICAUTH("BasicAuth"),
	/** No authorization. */
	NONE("None");

	private final String type;

	/**
	 * Constructs an enum constant with the given scheme name.
	 * @param type the scheme name
	 */
	AuthorizationTypeEnum(String type) {
		this.type = type;
	}

	/**
	 * Returns the scheme name of this constant.
	 * @return the scheme name
	 */
	public String get() {
		return type;
	}

	/**
	 * Returns whether this constant equals the given type.
	 * @param type the type to compare with
	 * @return {@code true} if the two are equal
	 */
	public boolean equals(AuthorizationTypeEnum type){
		return this.compareTo(type) == 0;
	}

	/**
	 * Returns whether this constant equals the given type name (case-insensitive).
	 * @param type the type name to compare with
	 * @return {@code true} if the two are equal
	 */
	public boolean equals(String type){
		return this.compareTo(AuthorizationTypeEnum.valueOfIgnoreCase(type)) == 0;
	}

	/**
	 * Resolves an enum constant from the given scheme name, ignoring case.
	 * @param type the scheme name
	 * @return the matching enum constant
	 * @throws NoSuchElementException if no constant matches
	 */
	public static AuthorizationTypeEnum valueOfIgnoreCase(String type) {
		for (AuthorizationTypeEnum transport : AuthorizationTypeEnum.values()) {
			if(transport.get().equalsIgnoreCase(type)) {
				return transport;
			}
		}
    	throw new NoSuchElementException("Cannot found AuthorizationType with type '" + type + "'.");
    }

}
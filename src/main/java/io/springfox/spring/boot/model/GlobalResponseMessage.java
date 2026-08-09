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
 * Global Swagger response messages per HTTP method.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Data
public class GlobalResponseMessage {

	/**
	 * Response message bodies for POST requests.
	 **/
	List<GlobalResponseMessageBody> post = new ArrayList<>();

	/**
	 * Response message bodies for GET requests.
	 **/
	List<GlobalResponseMessageBody> get = new ArrayList<>();

	/**
	 * Response message bodies for PUT requests.
	 **/
	List<GlobalResponseMessageBody> put = new ArrayList<>();

	/**
	 * Response message bodies for PATCH requests.
	 **/
	List<GlobalResponseMessageBody> patch = new ArrayList<>();

	/**
	 * Response message bodies for DELETE requests.
	 **/
	List<GlobalResponseMessageBody> delete = new ArrayList<>();

	/**
	 * Response message bodies for HEAD requests.
	 **/
	List<GlobalResponseMessageBody> head = new ArrayList<>();

	/**
	 * Response message bodies for OPTIONS requests.
	 **/
	List<GlobalResponseMessageBody> options = new ArrayList<>();

	/**
	 * Response message bodies for TRACE requests.
	 **/
	List<GlobalResponseMessageBody> trace = new ArrayList<>();

}
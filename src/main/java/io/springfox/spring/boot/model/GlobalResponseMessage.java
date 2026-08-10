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
 * Global Swagger response messages per HTTP method.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class GlobalResponseMessage {

	/**
	 * Response message bodies for POST requests.
	 **/
	private List<GlobalResponseMessageBody> post = new ArrayList<>();

	/**
	 * Response message bodies for GET requests.
	 **/
	private List<GlobalResponseMessageBody> get = new ArrayList<>();

	/**
	 * Response message bodies for PUT requests.
	 **/
	private List<GlobalResponseMessageBody> put = new ArrayList<>();

	/**
	 * Response message bodies for PATCH requests.
	 **/
	private List<GlobalResponseMessageBody> patch = new ArrayList<>();

	/**
	 * Response message bodies for DELETE requests.
	 **/
	private List<GlobalResponseMessageBody> delete = new ArrayList<>();

	/**
	 * Response message bodies for HEAD requests.
	 **/
	private List<GlobalResponseMessageBody> head = new ArrayList<>();

	/**
	 * Response message bodies for OPTIONS requests.
	 **/
	private List<GlobalResponseMessageBody> options = new ArrayList<>();

	/**
	 * Response message bodies for TRACE requests.
	 **/
	private List<GlobalResponseMessageBody> trace = new ArrayList<>();

	public List<GlobalResponseMessageBody> getPost() {
		return post;
	}

	public void setPost(List<GlobalResponseMessageBody> post) {
		this.post = post;
	}

	public List<GlobalResponseMessageBody> getGet() {
		return get;
	}

	public void setGet(List<GlobalResponseMessageBody> get) {
		this.get = get;
	}

	public List<GlobalResponseMessageBody> getPut() {
		return put;
	}

	public void setPut(List<GlobalResponseMessageBody> put) {
		this.put = put;
	}

	public List<GlobalResponseMessageBody> getPatch() {
		return patch;
	}

	public void setPatch(List<GlobalResponseMessageBody> patch) {
		this.patch = patch;
	}

	public List<GlobalResponseMessageBody> getDelete() {
		return delete;
	}

	public void setDelete(List<GlobalResponseMessageBody> delete) {
		this.delete = delete;
	}

	public List<GlobalResponseMessageBody> getHead() {
		return head;
	}

	public void setHead(List<GlobalResponseMessageBody> head) {
		this.head = head;
	}

	public List<GlobalResponseMessageBody> getOptions() {
		return options;
	}

	public void setOptions(List<GlobalResponseMessageBody> options) {
		this.options = options;
	}

	public List<GlobalResponseMessageBody> getTrace() {
		return trace;
	}

	public void setTrace(List<GlobalResponseMessageBody> trace) {
		this.trace = trace;
	}

	@Override
	public String toString() {
		return "GlobalResponseMessage{post=" + post + ", get=" + get + ", put=" + put + ", patch=" + patch
				+ ", delete=" + delete + ", head=" + head + ", options=" + options + ", trace=" + trace + "}";
	}

}

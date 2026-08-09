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
package io.springfox.spring.boot.extend;

import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.refs.GenericRef;
import io.swagger.models.refs.RefType;
 
/**
 * Swagger property combining the characteristics of {@link ArrayProperty} and
 * {@link RefProperty}. <p>Represents an array whose items are a reference to another
 * model definition.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class ArrayRefProperty extends ArrayProperty {

	private GenericRef genericRef;

	/**
	 * Returns the {@code $ref} string of this property.
	 * @return the reference string
	 */
	public String get$ref() {
		return genericRef.getRef();
	}

	/**
	 * Sets the {@code $ref} of this property and configures the array items to reference the
	 * given definition.
	 * @param ref the referenced definition name
	 */
	public void set$ref(String ref) {
		this.genericRef = new GenericRef(RefType.DEFINITION, ref);

		// $ref
		RefProperty items = new RefProperty();
		items.setType(ref);
		items.set$ref(ref);
		this.items(items);
	}
}
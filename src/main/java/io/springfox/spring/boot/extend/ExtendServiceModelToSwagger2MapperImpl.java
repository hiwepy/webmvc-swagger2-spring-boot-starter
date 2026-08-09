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

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.springfox.spring.boot.utils.SwaggerUtil;
import io.swagger.models.Model;
import io.swagger.models.Swagger;
import io.swagger.models.properties.AbstractProperty;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.BooleanProperty;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;
import springfox.documentation.service.Documentation;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2MapperImpl;

/**
 * Extended Swagger2 mapper that enriches generic response models. <p>Post-processes the
 * generated {@link Swagger} definitions so that generic {@code ApiRestResponse<T>} models
 * expose the actual type of their {@code data} property (e.g. arrays, references, maps).</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class ExtendServiceModelToSwagger2MapperImpl extends ServiceModelToSwagger2MapperImpl {

	private static final Logger log = LoggerFactory.getLogger(ExtendServiceModelToSwagger2MapperImpl.class);

	private ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Maps the Springfox {@link Documentation} into a Swagger document, then enhances the
	 * generic {@code ApiRestResponse} definitions.
	 * @param from the Springfox documentation
	 * @return the enhanced Swagger document
	 */
	@Override
	public Swagger mapDocumentation(Documentation from) {
		Swagger swagger = super.mapDocumentation(from);
		log.debug("Definitions: {}", swagger.getDefinitions());
		// Enhance response properties
		Iterator<Map.Entry<String, Model>> it = swagger.getDefinitions().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Model> entry = it.next();
			Model model = entry.getValue();
			String key = entry.getKey();
			if (key.contains("ApiRestResponse") && SwaggerUtil.hasGenerics(key)) {
				Map<String, Property> props = model.getProperties();
				Property dataProp = props.get("data");
				Property newProp = SwaggerUtil.getNewProp(dataProp, SwaggerUtil.getRealType(key), swagger.getDefinitions());
				try {
					log.debug("newProp:{}", objectMapper.writeValueAsString(newProp));
				} catch (JsonProcessingException e) {
				}
				props.put("data", newProp);
			}
		}

		// Enhance response properties
		while (it.hasNext()) {
			Map.Entry<String, Model> entry = it.next();
			Model model = entry.getValue();
			String key = entry.getKey();
			if (key.contains("ApiRestResponse") && SwaggerUtil.hasGenerics(key)) {
				Map<String, Property> props = model.getProperties();
				Property dataProp = props.get("data");
				if (dataProp.getType().equals("object")) {
					String realType = SwaggerUtil.getRealType(key);
					AbstractProperty newProp = null;
					if (SwaggerUtil.hasRef(key)) { // multi-level reference exists
						String ref = SwaggerUtil.getRef(key);
						/** List«T», Set«T»: supports findAll()-style queries */
						if (realType.startsWith("List«") || realType.startsWith("Set«")) {
							newProp = new ArrayRefProperty();
							BeanUtils.copyProperties(dataProp, newProp);
							((ArrayRefProperty) newProp).set$ref(ref);
							newProp.setType(ArrayRefProperty.TYPE);
						} else if (realType.startsWith("DBResult«")) { // DBResult«T»: supports query()-style queries
							newProp = new RefProperty();
							BeanUtils.copyProperties(dataProp, newProp);
							((RefProperty) newProp).set$ref(realType);
						} else if (realType.startsWith("Map«")) {
							newProp = new RefProperty();
							BeanUtils.copyProperties(dataProp, newProp);
							((RefProperty) newProp).set$ref(realType);
						} else {
							newProp = new RefProperty();
							BeanUtils.copyProperties(dataProp, newProp);
							((RefProperty) newProp).set$ref(ref);
						}
						// No reference relationship: handle the actual type
					} else if (realType.contains("boolean")) {
						newProp = new BooleanProperty();
						BeanUtils.copyProperties(dataProp, newProp);
						newProp.setType(BooleanProperty.TYPE);
					} else if (realType.contains("string")) {
						newProp = new StringProperty();
						BeanUtils.copyProperties(dataProp, newProp);
						newProp.setType(StringProperty.TYPE);
					} else if (realType.contains("int")) {
						newProp = new IntegerProperty();
						BeanUtils.copyProperties(dataProp, newProp);
						newProp.setType(IntegerProperty.TYPE);
					} else if (realType.contains("map")) {
						newProp = new MapProperty();
						BeanUtils.copyProperties(dataProp, newProp);
					} else if (realType.contains("list")) {
						newProp = new ArrayProperty();
						BeanUtils.copyProperties(dataProp, newProp);
					} else {
						newProp = (AbstractProperty) dataProp;
					}
					props.put("data", newProp);
				}
			}
		}

		try {
			log.debug("swagger:{}", objectMapper.writeValueAsString(swagger));
		} catch (JsonProcessingException e) {
		}
		return swagger;
	}

}

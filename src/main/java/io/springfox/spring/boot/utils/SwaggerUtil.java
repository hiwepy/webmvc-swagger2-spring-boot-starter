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
package io.springfox.spring.boot.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import io.springfox.spring.boot.extend.ArrayRefProperty;
import io.swagger.models.Model;
import io.swagger.models.properties.AbstractProperty;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.BooleanProperty;
import io.swagger.models.properties.DateTimeProperty;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.LongProperty;
import io.swagger.models.properties.ObjectProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.PropertyBuilder;
import io.swagger.models.properties.PropertyBuilder.PropertyId;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;
 
/**
 * Utilities for resolving Swagger property types from generic type expressions. <p>Handles
 * the {@code «»} guillemet notation used by Springfox for generic types, e.g.
 * {@code ApiRestResponse«Map«K,V»»}.</p>
 *
 * @author ChenZhiPing
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class SwaggerUtil {

	/**
	 * Returns whether the given type name is a Swagger base type.
	 * @param type the type name to check
	 * @return {@code true} if it is a base type
	 */
	public static boolean isBaseType(String type) {
		return SwaggerUtil.getSwaggerProperty(type) != null;
	}

	/**
	 * Returns the map of Swagger-supported type names to their default property instances.
	 * @return the supported type map
	 */
	public static Map<String, AbstractProperty> getPropMap() {
		Map<String, AbstractProperty> map = new HashMap<String, AbstractProperty>();
		map.put("integer", new IntegerProperty());
		map.put("int", new IntegerProperty());
		map.put("long", new LongProperty());
		map.put("string", new StringProperty());
		map.put("object", new ObjectProperty());
		map.put("array", new ArrayProperty());
		map.put("boolean", new BooleanProperty());
		map.put("date", new DateTimeProperty());
		return map;
	}

	/**
	 * Resolves the Swagger property for the given Java type name.
	 * @param type the Java type name
	 * @return the matching Swagger property, or {@code null} if unknown
	 */
	public static AbstractProperty getSwaggerProperty(String type) {
		type = type.toLowerCase();
		return SwaggerUtil.getPropMap().get(type);
	}

	/**
	 * Returns whether the given type name denotes a {@code Map}.
	 * @param type the type name to check
	 * @return {@code true} if the type is a map
	 */
	public static boolean isMap(String type) {
		type = type.toLowerCase();
		return type.startsWith("map");
	}

	/**
	 * Returns whether the given type name denotes an iterable (a {@code List} or {@code Set}).
	 * @param type the type name to check
	 * @return {@code true} if the type is iterable
	 */
	public static boolean isIterable(String type) {
		type = type.toLowerCase();
		return type.startsWith("list") || type.startsWith("set");
	}

	/**
	 * Extracts the first non-base reference type parameter {@code T} from a generic
	 * expression. <p>For inputs such as {@code A«List«C1»»}, {@code A«C2»},
	 * {@code A«B«String,«String,List«C4»»»»}, returns {@code C1}, {@code C2}, {@code C4}
	 * respectively.</p>
	 * @param type the generic type expression
	 * @return the referenced type, or {@code "!!Unknown T!!"} if it cannot be resolved
	 */
	public static String getRef(String type) {
		try {
			String m = type.substring(type.lastIndexOf("«") + 1, type.indexOf("»"));
			String[] cc = m.split(",");
			for (String c : cc) {
				if (!SwaggerUtil.isBaseType(c)) {
					return c;
				}
			}
			return type;
		} catch (Exception e) {
 
		}
		return "!!Unknown T!!";
	}
 
	/**
	 * Extracts the inner type by stripping the outermost {@code «»} wrapper.
	 * @param type e.g. {@code ApiRestResponse«Map«Operator, List«Map«String, Customer»»»»}
	 * @return the inner expression, e.g. {@code Map«Operator, List«Map«String, Customer»»»}
	 */
	public static String getRealType(String type) {
		try {
			String m = type.substring(type.indexOf("«") + 1, type.lastIndexOf("»"));
			return m;
		} catch (Exception e) {
 
		}
		return type;
	}
 
	/**
	 * Returns whether the given type expression contains a non-base reference type.
	 * @param type the type expression to inspect
	 * @return {@code true} if a reference type is present
	 */
	public static boolean hasRef(String type) {
		if (type.indexOf("»") > 0) {
			try {
				String m = type.substring(type.lastIndexOf("«") + 1, type.indexOf("»"));
				String[] cc = m.split(",");
				for (String c : cc) {
					if (!SwaggerUtil.isBaseType(c)) {
						return true;
					}
				}
				return false;
			} catch (Exception e) {
				return false;
			}
		} else {
			return !SwaggerUtil.isBaseType(type);
		}
	}
	
	/**
	 * Returns whether the given type expression has generic type parameters.
	 * @param type the type expression to inspect
	 * @return {@code true} if the type is generic
	 */
	public static boolean hasGenerics(String type) {
		if (type.indexOf("»") > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Recursively resolves the Swagger property for a generic type expression, e.g.
	 * {@code ApiRestResponse«Map«Map«Long, Operator», List«Map«String, Customer»»»»}.
	 * @param dataProp the original data property to copy metadata from
	 * @param type the generic type expression
	 * @param definitions the available model definitions
	 * @return the resolved property, or {@code null} if it cannot be resolved
	 */
	public static Property getNewProp(Property dataProp, String type, Map<String, Model> definitions) {
		Property newProp = null;
		Model model = definitions.get(type);
		Map<String, Property> props = null;
		if (null != model) {
			props = model.getProperties();
		}
		if (null == props) {
			props = new HashMap<String, Property>();
		}
		String realType = SwaggerUtil.getRealType(type);
		if (SwaggerUtil.isMap(type)) {
			String[] realTypes = SwaggerUtil.splitByComma(realType);
 
			Map<PropertyId, Object> argsK = new HashMap<PropertyId, Object>();
			argsK.put(PropertyBuilder.PropertyId.DESCRIPTION, "Map key");
			argsK.put(PropertyBuilder.PropertyId.TYPE, realTypes[0].toLowerCase());
			AbstractProperty _prop0 = SwaggerUtil.getSwaggerProperty(realTypes[0]);
			Property propK = PropertyBuilder.build(null == _prop0 ? "object" : _prop0.getType(),
					null == _prop0 ? null : _prop0.getFormat(), argsK);
			propK.setName("key");
 
			Map<PropertyId, Object> argsV = new HashMap<PropertyId, Object>();
			argsV.put(PropertyBuilder.PropertyId.DESCRIPTION, "Map value");
			argsV.put(PropertyBuilder.PropertyId.TYPE, realTypes[1].toLowerCase());
			AbstractProperty _prop1 = SwaggerUtil.getSwaggerProperty(realTypes[1]);
			Property propV = PropertyBuilder.build(null == _prop1 ? "object" : _prop1.getType(),
					null == _prop1 ? null : _prop1.getFormat(), argsV);
			propV.setName("value");
 
			if (!realType.equals(type)) {
				propK = SwaggerUtil.getNewProp(propK, realTypes[0], definitions);
				propV = SwaggerUtil.getNewProp(propV, realTypes[1], definitions);
			}
 
			props.put(propK.getName(), propK);
			props.put(propV.getName(), propV);
 
			newProp = new RefProperty();
			BeanUtils.copyProperties(dataProp, newProp);
			((RefProperty) newProp).set$ref(type);
		} else if (SwaggerUtil.isIterable(type)) {
			String ref = SwaggerUtil.getRealType(type);
			newProp = new ArrayRefProperty();
			BeanUtils.copyProperties(dataProp, newProp);
			((ArrayRefProperty) newProp).set$ref(ref);
			((ArrayRefProperty) newProp).setType(ArrayRefProperty.TYPE);
			if (!realType.equals(type)) {
				SwaggerUtil.getNewProp(dataProp, realType, definitions);
			}
		} else if (SwaggerUtil.isBaseType(type)) {
			Map<PropertyId, Object> args = new HashMap<PropertyId, Object>();
			args.put(PropertyBuilder.PropertyId.DESCRIPTION, dataProp.getDescription());
			args.put(PropertyBuilder.PropertyId.TYPE, type.toLowerCase());
			AbstractProperty _prop = SwaggerUtil.getSwaggerProperty(type);
			newProp = PropertyBuilder.build(_prop.getType(), _prop.getFormat(), args);
			newProp.setName(dataProp.getName());
		} else if (SwaggerUtil.hasRef(type)) {
			newProp = new RefProperty();
			BeanUtils.copyProperties(dataProp, newProp);
			((RefProperty) newProp).set$ref(type);
		} else {
 
		}
		if (null != model) {
			model.setProperties(props);
		}
 
		return newProp;
	}
 
	/**
	 * Splits a generic type expression on the top-level comma, i.e. the comma at nesting
	 * depth zero.
	 * @param str the generic type expression
	 * @return a two-element array holding the left and right parts
	 */
	public static String[] splitByComma(String str) {
		int index = 0;
		int has = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ("«".equals(c + "")) {
				has++;
			}
			if ("»".equals(c + "")) {
				has--;
			}
			if (",".equals(c + "") && has == 0) {
				index = i;
			}
		}
 
		String[] arr = new String[2];
		arr[0] = str.substring(0, index);
		arr[1] = str.substring(index + 1);
		return arr;
	}
 
	/**
	 * Standalone demo entry point that exercises {@link #getRealType(String)} and
	 * {@link #splitByComma(String)} with sample inputs.
	 * @param args unused command-line arguments
	 */
	public static void main(String[] args) {
		String[] ss = new String[] { "A«List«C1»»", "A«C2»", "A«B«String,«String,List«C4»»»»" };
		for (String s : ss) {
			String c = SwaggerUtil.getRealType(s);
			System.out.println(c);
		}
 
		String[] s2 = new String[] { "A,B«List«C1»»", "Map«A,B»,C«List«D»»",
				"Map«Map«A,B»,C«List«D»»,Map«A,B»,C«List«D»»»,C«List«D»»" };
		for (String s : s2) {
			String[] arr = SwaggerUtil.splitByComma(s);
			System.out.println(arr[0]);
			System.out.println(arr[1]);
		}
	}
}
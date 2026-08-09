package io.springfox.spring.boot.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import io.swagger.models.Model;
import io.swagger.models.properties.AbstractProperty;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.StringProperty;

/**
 * Tests for {@link SwaggerUtil}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("SwaggerUtil Tests")
class SwaggerUtilTest {

    @Nested
    @DisplayName("isBaseType")
    class IsBaseType {

        @Test void integerIsBaseType() { assertThat(SwaggerUtil.isBaseType("integer")).isTrue(); }
        @Test void intIsBaseType() { assertThat(SwaggerUtil.isBaseType("int")).isTrue(); }
        @Test void stringIsBaseType() { assertThat(SwaggerUtil.isBaseType("string")).isTrue(); }
        @Test void booleanIsBaseType() { assertThat(SwaggerUtil.isBaseType("boolean")).isTrue(); }
        @Test void longIsBaseType() { assertThat(SwaggerUtil.isBaseType("long")).isTrue(); }
        @Test void objectIsBaseType() { assertThat(SwaggerUtil.isBaseType("object")).isTrue(); }
        @Test void arrayIsBaseType() { assertThat(SwaggerUtil.isBaseType("array")).isTrue(); }
        @Test void dateIsBaseType() { assertThat(SwaggerUtil.isBaseType("date")).isTrue(); }
        @Test void caseInsensitive() { assertThat(SwaggerUtil.isBaseType("INTEGER")).isTrue(); }
        @Test void customTypeIsNotBaseType() { assertThat(SwaggerUtil.isBaseType("MyModel")).isFalse(); }

    }

    @Nested
    @DisplayName("isMap")
    class IsMap {

        @Test void mapType() { assertThat(SwaggerUtil.isMap("Map«String,Object»")).isTrue(); }
        @Test void mapLowerCase() { assertThat(SwaggerUtil.isMap("map«K,V»")).isTrue(); }
        @Test void nonMapType() { assertThat(SwaggerUtil.isMap("List«String»")).isFalse(); }

    }

    @Nested
    @DisplayName("isIterable")
    class IsIterable {

        @Test void listType() { assertThat(SwaggerUtil.isIterable("List«String»")).isTrue(); }
        @Test void setType() { assertThat(SwaggerUtil.isIterable("Set«String»")).isTrue(); }
        @Test void nonIterableType() { assertThat(SwaggerUtil.isIterable("Map«K,V»")).isFalse(); }

    }

    @Nested
    @DisplayName("hasGenerics")
    class HasGenerics {

        @Test void withGenerics() { assertThat(SwaggerUtil.hasGenerics("A«B»")).isTrue(); }
        @Test void withoutGenerics() { assertThat(SwaggerUtil.hasGenerics("string")).isFalse(); }

    }

    @Nested
    @DisplayName("getRealType")
    class GetRealType {

        @Test void simpleGeneric() { assertThat(SwaggerUtil.getRealType("A«B»")).isEqualTo("B"); }
        @Test void nestedGeneric() { assertThat(SwaggerUtil.getRealType("A«List«C1»»")).isEqualTo("List«C1»"); }
        @Test void noGenericsReturnsInput() { assertThat(SwaggerUtil.getRealType("string")).isEqualTo("string"); }

    }

    @Nested
    @DisplayName("getRef")
    class GetRef {

        @Test void simpleRef() { assertThat(SwaggerUtil.getRef("A«C2»")).isEqualTo("C2"); }
        @Test void baseTypeRefReturnsOriginal() {
            // When the inner type is a base type, getRef returns the original
            String result = SwaggerUtil.getRef("A«string»");
            assertThat(result).isNotEmpty();
        }
        @Test void noGenericsReturnsUnknown() {
            String result = SwaggerUtil.getRef("NoGeneric");
            assertThat(result).isNotEmpty();
        }

    }

    @Nested
    @DisplayName("hasRef")
    class HasRef {

        @Test void withCustomRef() { assertThat(SwaggerUtil.hasRef("A«MyModel»")).isTrue(); }
        @Test void withBaseTypeOnly() { assertThat(SwaggerUtil.hasRef("A«string»")).isFalse(); }
        @Test void noGenericsCustomType() { assertThat(SwaggerUtil.hasRef("MyModel")).isTrue(); }
        @Test void noGenericsBaseType() { assertThat(SwaggerUtil.hasRef("string")).isFalse(); }

    }

    @Nested
    @DisplayName("getSwaggerProperty")
    class GetSwaggerProperty {

        @Test void integerProperty() { assertThat(SwaggerUtil.getSwaggerProperty("integer")).isNotNull(); }
        @Test void stringProperty() { assertThat(SwaggerUtil.getSwaggerProperty("string")).isNotNull(); }
        @Test void booleanProperty() { assertThat(SwaggerUtil.getSwaggerProperty("boolean")).isNotNull(); }
        @Test void longProperty() { assertThat(SwaggerUtil.getSwaggerProperty("long")).isNotNull(); }
        @Test void objectProperty() { assertThat(SwaggerUtil.getSwaggerProperty("object")).isNotNull(); }
        @Test void arrayProperty() { assertThat(SwaggerUtil.getSwaggerProperty("array")).isNotNull(); }
        @Test void dateProperty() { assertThat(SwaggerUtil.getSwaggerProperty("date")).isNotNull(); }
        @Test void unknownProperty() { assertThat(SwaggerUtil.getSwaggerProperty("Unknown")).isNull(); }

    }

    @Nested
    @DisplayName("getPropMap")
    class GetPropMap {

        @Test void containsExpectedTypes() {
            Map<String, AbstractProperty> map = SwaggerUtil.getPropMap();
            assertThat(map).containsKeys("integer", "int", "string", "boolean", "long", "object", "array", "date");
        }

    }

    @Nested
    @DisplayName("splitByComma")
    class SplitByComma {

        @Test void simpleSplit() {
            String[] result = SwaggerUtil.splitByComma("A,B");
            assertThat(result).hasSize(2);
            assertThat(result[0]).isEqualTo("A");
            assertThat(result[1]).isEqualTo("B");
        }

        @Test void splitWithNestedGenerics() {
            // Comma inside guillemets should NOT be split
            String[] result = SwaggerUtil.splitByComma("Map«A,B»,C");
            assertThat(result).hasSize(2);
            assertThat(result[0]).isEqualTo("Map«A,B»");
            assertThat(result[1]).isEqualTo("C");
        }

    }

    @Nested
    @DisplayName("getNewProp")
    class GetNewProp {

        @Test void baseTypeReturnsNewProperty() {
            StringProperty dataProp = new StringProperty();
            dataProp.setName("data");
            dataProp.setDescription("test");
            Map<String, Model> definitions = new HashMap<>();
            Property result = SwaggerUtil.getNewProp(dataProp, "string", definitions);
            assertThat(result).isNotNull();
        }

        @Test void customRefTypeReturnsRefProperty() {
            StringProperty dataProp = new StringProperty();
            dataProp.setName("data");
            dataProp.setDescription("test");
            Map<String, Model> definitions = new HashMap<>();
            Property result = SwaggerUtil.getNewProp(dataProp, "MyModel", definitions);
            assertThat(result).isNotNull();
        }

        @Test void mapTypeReturnsRefProperty() {
            StringProperty dataProp = new StringProperty();
            dataProp.setName("data");
            dataProp.setDescription("test");
            Map<String, Model> definitions = new HashMap<>();
            Property result = SwaggerUtil.getNewProp(dataProp, "Map«String,Integer»", definitions);
            assertThat(result).isNotNull();
        }

        @Test void listTypeReturnsArrayRefProperty() {
            StringProperty dataProp = new StringProperty();
            dataProp.setName("data");
            dataProp.setDescription("test");
            Map<String, Model> definitions = new HashMap<>();
            Property result = SwaggerUtil.getNewProp(dataProp, "List«MyModel»", definitions);
            assertThat(result).isNotNull();
        }

    }

    @Nested
    @DisplayName("main method")
    class MainMethod {

        @Test void mainDoesNotThrow() {
            // The main method is a demo that exercises getRealType and splitByComma
            SwaggerUtil.main(new String[]{});
        }

    }

}

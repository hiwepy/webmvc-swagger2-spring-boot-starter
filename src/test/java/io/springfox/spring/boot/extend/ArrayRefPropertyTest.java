package io.springfox.spring.boot.extend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link ArrayRefProperty}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("ArrayRefProperty Tests")
class ArrayRefPropertyTest {

    @Test
    @DisplayName("Instance can be created via constructor")
    void testInstantiation() {
        ArrayRefProperty instance = new ArrayRefProperty();
        assertThat(instance).isNotNull();
    }

    @Test
    @DisplayName("set$ref and get$ref work")
    void testRef() {
        ArrayRefProperty instance = new ArrayRefProperty();
        instance.set$ref("MyModel");
        assertThat(instance.get$ref()).contains("MyModel");
    }

    @Test
    @DisplayName("TYPE constant exists")
    void testTypeConstant() {
        assertThat(ArrayRefProperty.TYPE).isNotNull();
    }

}

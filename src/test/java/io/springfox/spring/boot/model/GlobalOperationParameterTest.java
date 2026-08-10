package io.springfox.spring.boot.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link GlobalOperationParameter}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("GlobalOperationParameter Tests")
class GlobalOperationParameterTest {

    private GlobalOperationParameter param;

    @BeforeEach
    void setUp() {
        param = new GlobalOperationParameter();
    }

    @Test void defaultName() { assertThat(param.getName()).isNull(); }
    @Test void defaultDescription() { assertThat(param.getDescription()).isNull(); }
    @Test void defaultDefaultValue() { assertThat(param.getDefaultValue()).isNull(); }
    @Test void defaultModelRef() { assertThat(param.getModelRef()).isNull(); }
    @Test void defaultParameterType() { assertThat(param.getParameterType()).isNull(); }
    @Test void defaultRequired() { assertThat(param.isRequired()).isFalse(); }
    @Test void defaultHidden() { assertThat(param.isHidden()).isFalse(); }
    @Test void defaultPattern() { assertThat(param.getPattern()).isNull(); }
    @Test void defaultAllowEmptyValue() { assertThat(param.isAllowEmptyValue()).isFalse(); }
    @Test void defaultScalarExample() { assertThat(param.getScalarExample()).isNull(); }

    @Test void setName() { param.setName("token"); assertThat(param.getName()).isEqualTo("token"); }
    @Test void setDescription() { param.setDescription("auth token"); assertThat(param.getDescription()).isEqualTo("auth token"); }
    @Test void setDefaultValue() { param.setDefaultValue("abc"); assertThat(param.getDefaultValue()).isEqualTo("abc"); }
    @Test void setModelRef() { param.setModelRef("string"); assertThat(param.getModelRef()).isEqualTo("string"); }
    @Test void setParameterType() { param.setParameterType("header"); assertThat(param.getParameterType()).isEqualTo("header"); }
    @Test void setRequired() { param.setRequired(true); assertThat(param.isRequired()).isTrue(); }
    @Test void setHidden() { param.setHidden(true); assertThat(param.isHidden()).isTrue(); }
    @Test void setPattern() { param.setPattern(".*"); assertThat(param.getPattern()).isEqualTo(".*"); }
    @Test void setAllowEmptyValue() { param.setAllowEmptyValue(true); assertThat(param.isAllowEmptyValue()).isTrue(); }
    @Test void setScalarExample() { param.setScalarExample("ex"); assertThat(param.getScalarExample()).isEqualTo("ex"); }

    @Test
    void toStringContainsFields() {
        param.setName("token");
        assertThat(param.toString()).contains("token");
    }

}

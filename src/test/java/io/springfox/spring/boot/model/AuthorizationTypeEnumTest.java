package io.springfox.spring.boot.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AuthorizationTypeEnum}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("AuthorizationTypeEnum Tests")
class AuthorizationTypeEnumTest {

    @Test
    @DisplayName("APIKEY has correct type string")
    void testApiKey() {
        assertThat(AuthorizationTypeEnum.APIKEY.get()).isEqualTo("ApiKey");
    }

    @Test
    @DisplayName("BASICAUTH has correct type string")
    void testBasicAuth() {
        assertThat(AuthorizationTypeEnum.BASICAUTH.get()).isEqualTo("BasicAuth");
    }

    @Test
    @DisplayName("NONE has correct type string")
    void testNone() {
        assertThat(AuthorizationTypeEnum.NONE.get()).isEqualTo("None");
    }

    @Test
    @DisplayName("values() returns all constants")
    void testValues() {
        assertThat(AuthorizationTypeEnum.values()).hasSize(3);
    }

    @Test
    @DisplayName("valueOfIgnoreCase finds APIKEY")
    void testValueOfIgnoreCaseApiKey() {
        assertThat(AuthorizationTypeEnum.valueOfIgnoreCase("ApiKey")).isEqualTo(AuthorizationTypeEnum.APIKEY);
    }

    @Test
    @DisplayName("valueOfIgnoreCase is case-insensitive")
    void testValueOfIgnoreCaseCaseInsensitive() {
        assertThat(AuthorizationTypeEnum.valueOfIgnoreCase("apikey")).isEqualTo(AuthorizationTypeEnum.APIKEY);
        assertThat(AuthorizationTypeEnum.valueOfIgnoreCase("BASICAUTH")).isEqualTo(AuthorizationTypeEnum.BASICAUTH);
    }

    @Test
    @DisplayName("valueOfIgnoreCase throws for unknown type")
    void testValueOfIgnoreCaseUnknown() {
        assertThatThrownBy(() -> AuthorizationTypeEnum.valueOfIgnoreCase("unknown"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("equals(AuthorizationTypeEnum) works")
    void testEqualsEnum() {
        assertThat(AuthorizationTypeEnum.APIKEY.equals(AuthorizationTypeEnum.APIKEY)).isTrue();
        assertThat(AuthorizationTypeEnum.APIKEY.equals(AuthorizationTypeEnum.BASICAUTH)).isFalse();
    }

    @Test
    @DisplayName("equals(String) works")
    void testEqualsString() {
        assertThat(AuthorizationTypeEnum.APIKEY.equals("ApiKey")).isTrue();
        assertThat(AuthorizationTypeEnum.APIKEY.equals("BasicAuth")).isFalse();
    }

}

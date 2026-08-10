package io.springfox.spring.boot.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link Authorization}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("Authorization Tests")
class AuthorizationTest {

    private Authorization auth;

    @BeforeEach
    void setUp() {
        auth = new Authorization();
    }

    @Nested
    @DisplayName("Default values")
    class DefaultValues {

        @Test void defaultName() { assertThat(auth.getName()).isEqualTo("X-Authorization"); }
        @Test void defaultType() { assertThat(auth.getType()).isEqualTo(AuthorizationTypeEnum.APIKEY); }
        @Test void defaultKeyName() { assertThat(auth.getKeyName()).isEqualTo("token"); }
        @Test void defaultAuthRegex() { assertThat(auth.getAuthRegex()).isEqualTo("^.*$"); }

    }

    @Nested
    @DisplayName("Setters and getters")
    class SettersAndGetters {

        @Test void setName() { auth.setName("Auth"); assertThat(auth.getName()).isEqualTo("Auth"); }
        @Test void setType() { auth.setType(AuthorizationTypeEnum.BASICAUTH); assertThat(auth.getType()).isEqualTo(AuthorizationTypeEnum.BASICAUTH); }
        @Test void setKeyName() { auth.setKeyName("X-Token"); assertThat(auth.getKeyName()).isEqualTo("X-Token"); }
        @Test void setAuthRegex() { auth.setAuthRegex("/api/**"); assertThat(auth.getAuthRegex()).isEqualTo("/api/**"); }

    }

    @Test
    void toStringContainsKeyFields() {
        assertThat(auth.toString()).contains("X-Authorization").contains("APIKEY");
    }

}

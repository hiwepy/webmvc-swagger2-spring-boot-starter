package io.springfox.spring.boot.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link GlobalResponseMessageBody}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("GlobalResponseMessageBody Tests")
class GlobalResponseMessageBodyTest {

    private GlobalResponseMessageBody body;

    @BeforeEach
    void setUp() {
        body = new GlobalResponseMessageBody();
    }

    @Test void defaultCode() { assertThat(body.getCode()).isEqualTo(0); }
    @Test void defaultMessage() { assertThat(body.getMessage()).isNull(); }
    @Test void defaultModelRef() { assertThat(body.getModelRef()).isNull(); }

    @Test void setCode() { body.setCode(200); assertThat(body.getCode()).isEqualTo(200); }
    @Test void setMessage() { body.setMessage("OK"); assertThat(body.getMessage()).isEqualTo("OK"); }
    @Test void setModelRef() { body.setModelRef("string"); assertThat(body.getModelRef()).isEqualTo("string"); }

    @Test
    void toStringContainsFields() {
        body.setCode(200);
        body.setMessage("OK");
        assertThat(body.toString()).contains("200").contains("OK");
    }

}

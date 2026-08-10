package io.springfox.spring.boot.extend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link ExtendServiceModelToSwagger2MapperImpl}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("ExtendServiceModelToSwagger2MapperImpl Tests")
class ExtendServiceModelToSwagger2MapperImplTest {

    @Test
    @DisplayName("Instance can be created via constructor")
    void testInstantiation() {
        ExtendServiceModelToSwagger2MapperImpl instance = new ExtendServiceModelToSwagger2MapperImpl();
        assertThat(instance).isNotNull();
    }

}

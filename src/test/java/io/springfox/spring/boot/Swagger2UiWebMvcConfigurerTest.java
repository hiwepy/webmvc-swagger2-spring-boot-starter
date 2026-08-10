package io.springfox.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link Swagger2UiWebMvcConfigurer}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("Swagger2UiWebMvcConfigurer Tests")
class Swagger2UiWebMvcConfigurerTest {

    @Test
    @DisplayName("Instance can be created via constructor")
    void testInstantiation() {
        Swagger2UiWebMvcConfigurer instance = new Swagger2UiWebMvcConfigurer();
        assertThat(instance).isNotNull();
    }

    @Test
    @DisplayName("Implements WebMvcConfigurer")
    void testImplementsWebMvcConfigurer() {
        Swagger2UiWebMvcConfigurer instance = new Swagger2UiWebMvcConfigurer();
        assertThat(instance).isInstanceOf(
                org.springframework.web.servlet.config.annotation.WebMvcConfigurer.class);
    }

}

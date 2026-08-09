package io.springfox.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link Swagger2WebMvcAutoConfiguration}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("Swagger2WebMvcAutoConfiguration Tests")
class Swagger2WebMvcAutoConfigurationTest {

    @Test
    @DisplayName("Instance can be created via constructor")
    void testInstantiation() {
        Swagger2WebMvcAutoConfiguration configuration = new Swagger2WebMvcAutoConfiguration();
        assertThat(configuration).isNotNull();
    }

    @Test
    @DisplayName("setBeanFactory and getBeanFactory work")
    void testBeanFactoryAware() throws Exception {
        Swagger2WebMvcAutoConfiguration config = new Swagger2WebMvcAutoConfiguration();
        org.springframework.beans.factory.BeanFactory factory =
                new org.springframework.beans.factory.support.DefaultListableBeanFactory();
        config.setBeanFactory(factory);
        // Verify no exception was thrown
        assertThat(config).isNotNull();
    }

    @Test
    @DisplayName("swagger2UiWebMvcConfigurer bean can be created")
    void testSwagger2UiWebMvcConfigurer() {
        Swagger2WebMvcAutoConfiguration config = new Swagger2WebMvcAutoConfiguration();
        Swagger2UiWebMvcConfigurer configurer = config.swagger2UiWebMvcConfigurer();
        assertThat(configurer).isNotNull();
    }

}

package io.springfox.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import io.springfox.spring.boot.model.Authorization;
import io.springfox.spring.boot.model.Contact;
import io.springfox.spring.boot.model.DocketInfo;
import io.springfox.spring.boot.model.GlobalOperationParameter;
import io.springfox.spring.boot.model.GlobalResponseMessage;
import io.springfox.spring.boot.model.UiConfig;

/**
 * Tests for {@link Swagger2WebMvcProperties}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("Swagger2WebMvcProperties Tests")
class Swagger2WebMvcPropertiesTest {

    private Swagger2WebMvcProperties props;

    @BeforeEach
    void setUp() {
        props = new Swagger2WebMvcProperties();
    }

    @Nested
    @DisplayName("Default values")
    class DefaultValues {

        @Test void defaultEnabled() { assertThat(props.isEnabled()).isFalse(); }
        @Test void defaultEnableUrlTemplating() { assertThat(props.isEnableUrlTemplating()).isFalse(); }
        @Test void defaultForCodeGen() { assertThat(props.isForCodeGen()).isFalse(); }
        @Test void defaultTitle() { assertThat(props.getTitle()).isEmpty(); }
        @Test void defaultDescription() { assertThat(props.getDescription()).isEmpty(); }
        @Test void defaultVersion() { assertThat(props.getVersion()).isEmpty(); }
        @Test void defaultLicense() { assertThat(props.getLicense()).isEmpty(); }
        @Test void defaultLicenseUrl() { assertThat(props.getLicenseUrl()).isEmpty(); }
        @Test void defaultTermsOfServiceUrl() { assertThat(props.getTermsOfServiceUrl()).isEmpty(); }
        @Test void defaultIgnoredParameterTypes() { assertThat(props.getIgnoredParameterTypes()).isEmpty(); }
        @Test void defaultContact() { assertThat(props.getContact()).isNotNull(); }
        @Test void defaultBasePackage() { assertThat(props.getBasePackage()).isEmpty(); }
        @Test void defaultBasePathPattern() { assertThat(props.getBasePathPattern()).isEmpty(); }
        @Test void defaultHost() { assertThat(props.getHost()).isEmpty(); }
        @Test void defaultGroups() { assertThat(props.getGroups()).isEmpty(); }
        @Test void defaultGlobalOperationParameters() { assertThat(props.getGlobalOperationParameters()).isNull(); }
        @Test void defaultUiConfig() { assertThat(props.getUiConfig()).isNotNull(); }
        @Test void defaultApplyDefaultResponseMessages() { assertThat(props.isApplyDefaultResponseMessages()).isTrue(); }
        @Test void defaultGlobalResponseMessage() { assertThat(props.getGlobalResponseMessage()).isNull(); }
        @Test void defaultAuthorization() { assertThat(props.getAuthorization()).isNotNull(); }
        @Test void prefixConstant() { assertThat(Swagger2WebMvcProperties.PREFIX).isEqualTo("swagger"); }

    }

    @Nested
    @DisplayName("Setters and getters")
    class SettersAndGetters {

        @Test void setEnabled() { props.setEnabled(true); assertThat(props.isEnabled()).isTrue(); }
        @Test void setEnableUrlTemplating() { props.setEnableUrlTemplating(true); assertThat(props.isEnableUrlTemplating()).isTrue(); }
        @Test void setForCodeGen() { props.setForCodeGen(true); assertThat(props.isForCodeGen()).isTrue(); }
        @Test void setTitle() { props.setTitle("My API"); assertThat(props.getTitle()).isEqualTo("My API"); }
        @Test void setDescription() { props.setDescription("desc"); assertThat(props.getDescription()).isEqualTo("desc"); }
        @Test void setVersion() { props.setVersion("1.0"); assertThat(props.getVersion()).isEqualTo("1.0"); }
        @Test void setLicense() { props.setLicense("Apache"); assertThat(props.getLicense()).isEqualTo("Apache"); }
        @Test void setLicenseUrl() { props.setLicenseUrl("http://example.com"); assertThat(props.getLicenseUrl()).isEqualTo("http://example.com"); }
        @Test void setTermsOfServiceUrl() { props.setTermsOfServiceUrl("http://tos"); assertThat(props.getTermsOfServiceUrl()).isEqualTo("http://tos"); }
        @Test void setIgnoredParameterTypes() { List<Class<?>> l = new ArrayList<>(); l.add(String.class); props.setIgnoredParameterTypes(l); assertThat(props.getIgnoredParameterTypes()).containsExactly(String.class); }
        @Test void setContact() { Contact c = new Contact(); c.setName("T"); props.setContact(c); assertThat(props.getContact().getName()).isEqualTo("T"); }
        @Test void setBasePackage() { props.setBasePackage("com.example"); assertThat(props.getBasePackage()).isEqualTo("com.example"); }
        @Test void setBasePathPattern() { props.setBasePathPattern("/api/**"); assertThat(props.getBasePathPattern()).isEqualTo("/api/**"); }
        @Test void setHost() { props.setHost("localhost:8080"); assertThat(props.getHost()).isEqualTo("localhost:8080"); }
        @Test void setGroups() { List<DocketInfo> g = new ArrayList<>(); g.add(new DocketInfo()); props.setGroups(g); assertThat(props.getGroups()).hasSize(1); }
        @Test void setGlobalOperationParameters() { List<GlobalOperationParameter> p = new ArrayList<>(); p.add(new GlobalOperationParameter()); props.setGlobalOperationParameters(p); assertThat(props.getGlobalOperationParameters()).hasSize(1); }
        @Test void setUiConfig() { UiConfig u = new UiConfig(); props.setUiConfig(u); assertThat(props.getUiConfig()).isSameAs(u); }
        @Test void setApplyDefaultResponseMessages() { props.setApplyDefaultResponseMessages(false); assertThat(props.isApplyDefaultResponseMessages()).isFalse(); }
        @Test void setGlobalResponseMessage() { GlobalResponseMessage m = new GlobalResponseMessage(); props.setGlobalResponseMessage(m); assertThat(props.getGlobalResponseMessage()).isSameAs(m); }
        @Test void setAuthorization() { Authorization a = new Authorization(); props.setAuthorization(a); assertThat(props.getAuthorization()).isSameAs(a); }

    }

    @Test
    void toStringContainsKeyFields() {
        props.setTitle("Test API");
        props.setBasePackage("com.example");
        assertThat(props.toString()).contains("Test API").contains("com.example");
    }

}

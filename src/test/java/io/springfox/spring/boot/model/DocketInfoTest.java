package io.springfox.spring.boot.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link DocketInfo}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("DocketInfo Tests")
class DocketInfoTest {

    private DocketInfo info;

    @BeforeEach
    void setUp() {
        info = new DocketInfo();
    }

    @Test void defaultEnableUrlTemplating() { assertThat(info.isEnableUrlTemplating()).isFalse(); }
    @Test void defaultForCodeGen() { assertThat(info.isForCodeGen()).isFalse(); }
    @Test void defaultName() { assertThat(info.getName()).isEmpty(); }
    @Test void defaultTitle() { assertThat(info.getTitle()).isEmpty(); }
    @Test void defaultDescription() { assertThat(info.getDescription()).isEmpty(); }
    @Test void defaultVersion() { assertThat(info.getVersion()).isEmpty(); }
    @Test void defaultLicense() { assertThat(info.getLicense()).isEmpty(); }
    @Test void defaultLicenseUrl() { assertThat(info.getLicenseUrl()).isEmpty(); }
    @Test void defaultTermsOfServiceUrl() { assertThat(info.getTermsOfServiceUrl()).isEmpty(); }
    @Test void defaultContact() { assertThat(info.getContact()).isNotNull(); }
    @Test void defaultBasePackage() { assertThat(info.getBasePackage()).isEmpty(); }
    @Test void defaultBasePathPattern() { assertThat(info.getBasePathPattern()).isEmpty(); }
    @Test void defaultGlobalOperationParameters() { assertThat(info.getGlobalOperationParameters()).isNull(); }
    @Test void defaultIgnoredParameterTypes() { assertThat(info.getIgnoredParameterTypes()).isEmpty(); }

    @Test void setEnableUrlTemplating() { info.setEnableUrlTemplating(true); assertThat(info.isEnableUrlTemplating()).isTrue(); }
    @Test void setForCodeGen() { info.setForCodeGen(true); assertThat(info.isForCodeGen()).isTrue(); }
    @Test void setName() { info.setName("group1"); assertThat(info.getName()).isEqualTo("group1"); }
    @Test void setTitle() { info.setTitle("API"); assertThat(info.getTitle()).isEqualTo("API"); }
    @Test void setDescription() { info.setDescription("desc"); assertThat(info.getDescription()).isEqualTo("desc"); }
    @Test void setVersion() { info.setVersion("1.0"); assertThat(info.getVersion()).isEqualTo("1.0"); }
    @Test void setLicense() { info.setLicense("Apache"); assertThat(info.getLicense()).isEqualTo("Apache"); }
    @Test void setLicenseUrl() { info.setLicenseUrl("http://lic"); assertThat(info.getLicenseUrl()).isEqualTo("http://lic"); }
    @Test void setTermsOfServiceUrl() { info.setTermsOfServiceUrl("http://tos"); assertThat(info.getTermsOfServiceUrl()).isEqualTo("http://tos"); }
    @Test void setContact() { Contact c = new Contact(); info.setContact(c); assertThat(info.getContact()).isSameAs(c); }
    @Test void setBasePackage() { info.setBasePackage("com.example"); assertThat(info.getBasePackage()).isEqualTo("com.example"); }
    @Test void setBasePathPattern() { info.setBasePathPattern("/api/**"); assertThat(info.getBasePathPattern()).isEqualTo("/api/**"); }
    @Test void setGlobalOperationParameters() { List<GlobalOperationParameter> p = new ArrayList<>(); info.setGlobalOperationParameters(p); assertThat(info.getGlobalOperationParameters()).isSameAs(p); }
    @Test void setIgnoredParameterTypes() { List<Class<?>> l = new ArrayList<>(); l.add(String.class); info.setIgnoredParameterTypes(l); assertThat(info.getIgnoredParameterTypes()).containsExactly(String.class); }

    @Test
    void toStringContainsFields() {
        info.setName("group1");
        assertThat(info.toString()).contains("group1");
    }

}

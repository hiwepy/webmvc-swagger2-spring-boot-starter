package io.springfox.spring.boot.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;

/**
 * Tests for {@link UiConfig}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("UiConfig Tests")
class UiConfigTest {

    private UiConfig config;

    @BeforeEach
    void setUp() {
        config = new UiConfig();
    }

    @Test void defaultApiSorter() { assertThat(config.getApiSorter()).isEqualTo("alpha"); }
    @Test void defaultJsonEditor() { assertThat(config.getJsonEditor()).isFalse(); }
    @Test void defaultShowRequestHeaders() { assertThat(config.getShowRequestHeaders()).isTrue(); }
    @Test void defaultSubmitMethods() { assertThat(config.getSubmitMethods()).isEqualTo("get,post,put,delete,patch"); }
    @Test void defaultRequestTimeout() { assertThat(config.getRequestTimeout()).isEqualTo(10000L); }
    @Test void defaultDeepLinking() { assertThat(config.getDeepLinking()).isNull(); }
    @Test void defaultDisplayOperationId() { assertThat(config.getDisplayOperationId()).isNull(); }
    @Test void defaultDefaultModelsExpandDepth() { assertThat(config.getDefaultModelsExpandDepth()).isNull(); }
    @Test void defaultDefaultModelExpandDepth() { assertThat(config.getDefaultModelExpandDepth()).isNull(); }
    @Test void defaultDefaultModelRendering() { assertThat(config.getDefaultModelRendering()).isNull(); }
    @Test void defaultDisplayRequestDuration() { assertThat(config.getDisplayRequestDuration()).isTrue(); }
    @Test void defaultDocExpansion() { assertThat(config.getDocExpansion()).isNull(); }
    @Test void defaultFilter() { assertThat(config.getFilter()).isNull(); }
    @Test void defaultMaxDisplayedTags() { assertThat(config.getMaxDisplayedTags()).isNull(); }
    @Test void defaultOperationsSorter() { assertThat(config.getOperationsSorter()).isNull(); }
    @Test void defaultShowExtensions() { assertThat(config.getShowExtensions()).isNull(); }
    @Test void defaultTagsSorter() { assertThat(config.getTagsSorter()).isNull(); }
    @Test void defaultValidatorUrl() { assertThat(config.getValidatorUrl()).isNull(); }

    @Test void setApiSorter() { config.setApiSorter("beta"); assertThat(config.getApiSorter()).isEqualTo("beta"); }
    @Test void setJsonEditor() { config.setJsonEditor(true); assertThat(config.getJsonEditor()).isTrue(); }
    @Test void setShowRequestHeaders() { config.setShowRequestHeaders(false); assertThat(config.getShowRequestHeaders()).isFalse(); }
    @Test void setSubmitMethods() { config.setSubmitMethods("get"); assertThat(config.getSubmitMethods()).isEqualTo("get"); }
    @Test void setRequestTimeout() { config.setRequestTimeout(5000L); assertThat(config.getRequestTimeout()).isEqualTo(5000L); }
    @Test void setDeepLinking() { config.setDeepLinking(true); assertThat(config.getDeepLinking()).isTrue(); }
    @Test void setDisplayOperationId() { config.setDisplayOperationId(true); assertThat(config.getDisplayOperationId()).isTrue(); }
    @Test void setDefaultModelsExpandDepth() { config.setDefaultModelsExpandDepth(2); assertThat(config.getDefaultModelsExpandDepth()).isEqualTo(2); }
    @Test void setDefaultModelExpandDepth() { config.setDefaultModelExpandDepth(3); assertThat(config.getDefaultModelExpandDepth()).isEqualTo(3); }
    @Test void setDefaultModelRendering() { config.setDefaultModelRendering(ModelRendering.EXAMPLE); assertThat(config.getDefaultModelRendering()).isEqualTo(ModelRendering.EXAMPLE); }
    @Test void setDisplayRequestDuration() { config.setDisplayRequestDuration(false); assertThat(config.getDisplayRequestDuration()).isFalse(); }
    @Test void setDocExpansion() { config.setDocExpansion(DocExpansion.LIST); assertThat(config.getDocExpansion()).isEqualTo(DocExpansion.LIST); }
    @Test void setFilter() { config.setFilter("test"); assertThat(config.getFilter()).isEqualTo("test"); }
    @Test void setMaxDisplayedTags() { config.setMaxDisplayedTags(10); assertThat(config.getMaxDisplayedTags()).isEqualTo(10); }
    @Test void setOperationsSorter() { config.setOperationsSorter(OperationsSorter.ALPHA); assertThat(config.getOperationsSorter()).isEqualTo(OperationsSorter.ALPHA); }
    @Test void setShowExtensions() { config.setShowExtensions(true); assertThat(config.getShowExtensions()).isTrue(); }
    @Test void setTagsSorter() { config.setTagsSorter(TagsSorter.ALPHA); assertThat(config.getTagsSorter()).isEqualTo(TagsSorter.ALPHA); }
    @Test void setValidatorUrl() { config.setValidatorUrl("http://val"); assertThat(config.getValidatorUrl()).isEqualTo("http://val"); }

    @Test
    void toStringContainsFields() {
        config.setApiSorter("beta");
        assertThat(config.toString()).contains("beta");
    }

}

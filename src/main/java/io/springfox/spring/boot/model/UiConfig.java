/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.springfox.spring.boot.model;

import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;

/**
 * Configuration for the Swagger UI page.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class UiConfig {

    private String apiSorter = "alpha";

    /**
     * Whether the JSON editor is enabled.
     **/
    private Boolean jsonEditor = false;
    /**
     * Whether to show the request headers.
     **/
    private Boolean showRequestHeaders = true;
    /**
     * Comma-separated request methods that can be submitted from the UI.
     **/
    private String submitMethods = "get,post,put,delete,patch";
    /**
     * Request timeout in milliseconds.
     **/
    private Long requestTimeout = 10000L;

    private Boolean deepLinking;
    private Boolean displayOperationId;
    private Integer defaultModelsExpandDepth;
    private Integer defaultModelExpandDepth;
    private ModelRendering defaultModelRendering;

    /**
     * Whether to display the request duration; defaults to {@code false}.
     */
    private Boolean displayRequestDuration = true;
    /**
     * Default expansion mode: {@code none} or {@code list}.
     */
    private DocExpansion docExpansion;
    /**
     * Filter: a {@code Boolean=false} or a {@code String}.
     */
    private Object filter;
    private Integer maxDisplayedTags;
    private OperationsSorter operationsSorter;
    private Boolean showExtensions;
    private TagsSorter tagsSorter;

    /**
     * Network validator URL.
     */
    private String validatorUrl;

    public String getApiSorter() {
        return apiSorter;
    }

    public void setApiSorter(String apiSorter) {
        this.apiSorter = apiSorter;
    }

    public Boolean getJsonEditor() {
        return jsonEditor;
    }

    public void setJsonEditor(Boolean jsonEditor) {
        this.jsonEditor = jsonEditor;
    }

    public Boolean getShowRequestHeaders() {
        return showRequestHeaders;
    }

    public void setShowRequestHeaders(Boolean showRequestHeaders) {
        this.showRequestHeaders = showRequestHeaders;
    }

    public String getSubmitMethods() {
        return submitMethods;
    }

    public void setSubmitMethods(String submitMethods) {
        this.submitMethods = submitMethods;
    }

    public Long getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(Long requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public Boolean getDeepLinking() {
        return deepLinking;
    }

    public void setDeepLinking(Boolean deepLinking) {
        this.deepLinking = deepLinking;
    }

    public Boolean getDisplayOperationId() {
        return displayOperationId;
    }

    public void setDisplayOperationId(Boolean displayOperationId) {
        this.displayOperationId = displayOperationId;
    }

    public Integer getDefaultModelsExpandDepth() {
        return defaultModelsExpandDepth;
    }

    public void setDefaultModelsExpandDepth(Integer defaultModelsExpandDepth) {
        this.defaultModelsExpandDepth = defaultModelsExpandDepth;
    }

    public Integer getDefaultModelExpandDepth() {
        return defaultModelExpandDepth;
    }

    public void setDefaultModelExpandDepth(Integer defaultModelExpandDepth) {
        this.defaultModelExpandDepth = defaultModelExpandDepth;
    }

    public ModelRendering getDefaultModelRendering() {
        return defaultModelRendering;
    }

    public void setDefaultModelRendering(ModelRendering defaultModelRendering) {
        this.defaultModelRendering = defaultModelRendering;
    }

    public Boolean getDisplayRequestDuration() {
        return displayRequestDuration;
    }

    public void setDisplayRequestDuration(Boolean displayRequestDuration) {
        this.displayRequestDuration = displayRequestDuration;
    }

    public DocExpansion getDocExpansion() {
        return docExpansion;
    }

    public void setDocExpansion(DocExpansion docExpansion) {
        this.docExpansion = docExpansion;
    }

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }

    public Integer getMaxDisplayedTags() {
        return maxDisplayedTags;
    }

    public void setMaxDisplayedTags(Integer maxDisplayedTags) {
        this.maxDisplayedTags = maxDisplayedTags;
    }

    public OperationsSorter getOperationsSorter() {
        return operationsSorter;
    }

    public void setOperationsSorter(OperationsSorter operationsSorter) {
        this.operationsSorter = operationsSorter;
    }

    public Boolean getShowExtensions() {
        return showExtensions;
    }

    public void setShowExtensions(Boolean showExtensions) {
        this.showExtensions = showExtensions;
    }

    public TagsSorter getTagsSorter() {
        return tagsSorter;
    }

    public void setTagsSorter(TagsSorter tagsSorter) {
        this.tagsSorter = tagsSorter;
    }

    public String getValidatorUrl() {
        return validatorUrl;
    }

    public void setValidatorUrl(String validatorUrl) {
        this.validatorUrl = validatorUrl;
    }

    @Override
    public String toString() {
        return "UiConfig{apiSorter='" + apiSorter + "', deepLinking=" + deepLinking + ", docExpansion=" + docExpansion + "}";
    }

}

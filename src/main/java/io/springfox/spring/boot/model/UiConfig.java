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

import lombok.Data;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
/**
 * Configuration for the Swagger UI page.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Data
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

}
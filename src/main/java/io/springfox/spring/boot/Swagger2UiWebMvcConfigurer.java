package io.springfox.spring.boot;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.LiteWebJarsResourceResolver;

/**
 * WebMVC configurer that exposes Swagger UI static resources. <p>Maps the
 * {@code /swagger-ui/**}, {@code /doc.html} and (optionally) {@code /webjars/**} URL patterns
 * to their classpath resource locations, and forwards the Swagger UI root to the index page.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class Swagger2UiWebMvcConfigurer implements WebMvcConfigurer {

	private final String META_INF_RESOURCES = "classpath:/META-INF/resources/";
	private final String META_INF_WEBJAR_RESOURCES = META_INF_RESOURCES + "webjars/";
	private final String META_INF_SPRINGFOX_SWAGGER_UI_RESOURCES = META_INF_WEBJAR_RESOURCES + "springfox-swagger-ui/";

	/**
	 * Registers resource handlers for the Swagger UI assets.
	 * @param registry the resource-handler registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**").addResourceLocations(META_INF_SPRINGFOX_SWAGGER_UI_RESOURCES).resourceChain(false);
		registry.addResourceHandler("/doc.html").addResourceLocations(META_INF_RESOURCES).resourceChain(false);;
		if(!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**").addResourceLocations(META_INF_WEBJAR_RESOURCES)
				.resourceChain(false).addResolver(new LiteWebJarsResourceResolver());
		}
	}

	/**
	 * Forwards the Swagger UI root view to the index HTML page.
	 * @param registry the view-controller registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/swagger-ui/").setViewName("forward:/swagger-ui/index.html");
	}

}

package com.oskiapps.shopsapp.engine.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.TransformedResource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	public static final String API_PATH = "/api";
	private static final String PATH_PATTERNS = "/**";
	private static final String FRONT_CONTROLLER = "index.html";
	private static final String BASE_HREF_PLACEHOLDER = "#base-href#";
	private static final String FRONT_CONTROLLER_ENCODING = StandardCharsets.UTF_8.name();

	private final String contextPath;
	private final ResourceProperties resourceProperties;

	public WebConfig(@Value("${server.servlet.context-path}") String contextPath,
			ResourceProperties resourceProperties) {
		this.contextPath = contextPath;
		this.resourceProperties = resourceProperties;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(PATH_PATTERNS).addResourceLocations(resourceProperties.getStaticLocations())
				.resourceChain(true).addResolver(new SinglePageAppResourceResolver());
	}

	private class SinglePageAppResourceResolver extends PathResourceResolver {

		private static final String URL_SEPARATOR = "/";

		private TransformedResource transformedResource(Resource resource) throws IOException {
			String fileContent = IOUtils.toString(resource.getInputStream(), FRONT_CONTROLLER_ENCODING);
			fileContent = fileContent.replace(BASE_HREF_PLACEHOLDER, buildBaseHref());
			return new TransformedResource(resource, fileContent.getBytes());
		}

		private String buildBaseHref() {
			return contextPath + URL_SEPARATOR;
		}

		@Override
		protected Resource getResource(String resourcePath, Resource location) throws IOException {
			Resource resource = location.createRelative(resourcePath);
			if (resource.exists() && resource.isReadable()) {

				if (resourcePath.contains(FRONT_CONTROLLER)) {
					return transformedResource(resource);
				}

				return resource;
			}

			if ((URL_SEPARATOR + resourcePath).startsWith(API_PATH)) {
				return null;
			}

			resource = location.createRelative(FRONT_CONTROLLER);
			if (resource.exists() && resource.isReadable()) {
				return transformedResource(resource);
			}

			return null;
		}
	}
}
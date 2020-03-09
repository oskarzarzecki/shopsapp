package com.oskiapps.shopsapp.engine.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("shops.app.rest")
public class RestProperties {

	private String frontendOrigin;

	public String getFrontendOrigin() {
		return frontendOrigin;
	}

	public void setFrontendOrigin(String frontendOrigin) {
		this.frontendOrigin = frontendOrigin;
	}

}

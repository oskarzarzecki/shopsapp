package com.oskiapps.shopsapp.engine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.oskiapps.shopsapp.engine.config.properties.RestProperties;

@Configuration
public class RestConfig {

	@Autowired
	private RestProperties restProperties;

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.applyPermitDefaultValues();
		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedOrigin(restProperties.getFrontendOrigin());
		corsConfig.addAllowedOrigin("http://localhost:4200");
		corsConfig.addAllowedOrigin("http://localhost:4201");
		corsConfig.addAllowedOrigin("http://localhost:4202");
		corsConfig.addAllowedHeader("*");
		corsConfig.addAllowedMethod("OPTIONS");
		corsConfig.addAllowedMethod("GET");
		corsConfig.addAllowedMethod("POST");
		corsConfig.addAllowedMethod("PUT");
		corsConfig.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", corsConfig);
		return new CorsFilter(source);
	}

}

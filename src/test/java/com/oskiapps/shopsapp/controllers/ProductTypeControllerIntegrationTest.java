package com.oskiapps.shopsapp.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.oskiapps.shopsapp.ControllerIntegrationTest;

class ProductTypeControllerIntegrationTest extends ControllerIntegrationTest {

	@Test
	void testPing() {
		ResponseEntity<String> result = restTemplate.exchange(createUrl("/product-types"), HttpMethod.GET, null,
				String.class);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}

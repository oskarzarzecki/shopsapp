package com.oskiapps.shopsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ControllerIntegrationTest {

	@Autowired
	protected TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	static String baseUrl = "http://localhost:";

	protected String createUrl(String string) {
		return baseUrl + randomServerPort + string;
	}

}

package com.oskiapps.shopsapp.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.oskiapps.shopsapp.ControllerTest;

class ProductTypeControllerTest extends ControllerTest {

	@Test
	void testFindAllAvailableNotDeleted() throws Exception {
		mockMvc.perform(get("/product-types").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is("ProductType1")))
				.andExpect(jsonPath("$[1].name", is("ProductType2")))
				.andExpect(jsonPath("$[2].name", is("ProductTypeNoCategories"))).andExpect(jsonPath("$.*", hasSize(3)))
				.andExpect(jsonPath("$[0].productCategories.*", hasSize(2)))
				.andExpect(jsonPath("$[1].productCategories.*", hasSize(1)));
	}

}

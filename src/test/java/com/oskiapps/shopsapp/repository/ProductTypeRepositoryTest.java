package com.oskiapps.shopsapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oskiapps.shopsapp.RepositoryIntegrationTest;
import com.oskiapps.shopsapp.model.entities.ProductType;

public class ProductTypeRepositoryTest extends RepositoryIntegrationTest {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Test
	public void testFindAll() {
		List<ProductType> productTypes = productTypeRepository.findAll();
		assertNotNull(productTypes);
		assertEquals(6, productTypes.size());
	}

	@Test
	public void testFindAllAvailableNotDeleted() {
		List<ProductType> productTypes = productTypeRepository.findAllAvailableNotDeletedWithCategories();
		assertNotNull(productTypes);
		assertEquals(3, productTypes.size());
		assertEquals(2, productTypes.get(0).getProductCategories().size());
		assertEquals(1, productTypes.get(1).getProductCategories().size());
	}

}

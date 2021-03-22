package com.oskiapps.shopsapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.oskiapps.shopsapp.model.entities.ProductType;
import com.oskiapps.shopsapp.model.entities.ProductType.Views.AllProductTypesWithCategories;
import com.oskiapps.shopsapp.repository.ProductTypeRepository;

@RestController
@RequestMapping("/product-types")
public class ProductTypeController {

	@Autowired
	ProductTypeRepository productTypeRepository;

	@GetMapping("")
	@JsonView(AllProductTypesWithCategories.class)
	public List<ProductType> getAllProductTypes() {
		return productTypeRepository.findAllAvailableNotDeletedWithCategories();
	}

}

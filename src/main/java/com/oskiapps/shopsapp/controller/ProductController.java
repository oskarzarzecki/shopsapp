package com.oskiapps.shopsapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oskiapps.shopsapp.model.Product;
import com.oskiapps.shopsapp.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("")
	public List<Product> listPosts() {
		return productRepository.findAll();
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Optional<Product> getProduct(@PathVariable("id") Long id) {
		return productRepository.findById(id);
	}

	@RequestMapping("/test")
	public String testController() {
		return "test controller";
	}

}

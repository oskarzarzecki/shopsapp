package com.oskiapps.shopsapp.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oskiapps.shopsapp.engine.services.FileStorageService;
import com.oskiapps.shopsapp.model.entities.Product;
import com.oskiapps.shopsapp.model.entities.ProductImage;
import com.oskiapps.shopsapp.repository.ProductImageRepository;
import com.oskiapps.shopsapp.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private ProductImageRepository productImageRepository;

	@GetMapping("")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping(value = "/product/{id}")
	public Optional<Product> getProduct(@PathVariable("id") Long id) {
		return productRepository.findById(id);
	}

	@GetMapping("/get-product-image")
	public ResponseEntity<Resource> getProductImage(@RequestParam(value = "idProduct", required = true) Long idProduct,
			@RequestParam(value = "idProductImage", required = true) Long idProductImage, HttpServletRequest request) {

		ProductImage image = this.productImageRepository.findById(idProductImage).get();
		String productImagePath = image.getPath();
		String filePath = ProductRepository.PRODUCT_IMAGE_FILE_PATH + "/" + idProduct + "/" + productImagePath;
		Resource resource = fileStorageService.loadImageResource(filePath);

		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}

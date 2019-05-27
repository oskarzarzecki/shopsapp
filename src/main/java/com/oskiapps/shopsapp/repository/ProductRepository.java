package com.oskiapps.shopsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oskiapps.shopsapp.model.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public static final String PRODUCT_IMAGE_FILE_PATH = "/product";

}

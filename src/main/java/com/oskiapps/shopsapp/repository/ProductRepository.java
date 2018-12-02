package com.oskiapps.shopsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.oskiapps.shopsapp.model.Product;

@Service
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}

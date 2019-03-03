package com.oskiapps.shopsapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oskiapps.shopsapp.model.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

	@Query("select id from Product p where p.id = ?1")
	List<Long> findPromotedProductImage(long idProduct);

}

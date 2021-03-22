package com.oskiapps.shopsapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oskiapps.shopsapp.model.entities.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long>, JpaSpecificationExecutor<ProductType> {

	List<ProductType> findAll();

	@Query("SELECT DISTINCT t FROM ProductType t LEFT JOIN FETCH t.productCategories c WHERE t.deleted = 0 AND t.available = 1 AND (c.deleted = 0 AND c.available = 1 OR c.deleted IS NULL)")
	List<ProductType> findAllAvailableNotDeletedWithCategories();

}

package com.oskiapps.shopsapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.oskiapps.shopsapp.model.entities.Auction;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long>, JpaSpecificationExecutor<Auction> {

	Page<Auction> findAllByProductProductCategoryId(long id, Pageable pageRequest);

	int countByProductProductCategoryId(long id);

}

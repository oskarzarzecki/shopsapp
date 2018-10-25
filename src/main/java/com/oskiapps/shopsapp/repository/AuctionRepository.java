package com.oskiapps.shopsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oskiapps.shopsapp.model.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

}

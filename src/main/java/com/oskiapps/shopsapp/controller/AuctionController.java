package com.oskiapps.shopsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oskiapps.shopsapp.model.Auction;
import com.oskiapps.shopsapp.repository.AuctionRepository;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

	@Autowired
	AuctionRepository auctionRepository;

	@GetMapping("")
	public List<Auction> listPosts() {
		return auctionRepository.findAll();
	}

}

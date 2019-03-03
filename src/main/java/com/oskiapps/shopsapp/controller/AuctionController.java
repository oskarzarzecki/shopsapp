package com.oskiapps.shopsapp.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.oskiapps.shopsapp.engine.config.properties.customer.PromotedProductProperties;
import com.oskiapps.shopsapp.engine.utils.RandomSelector;
import com.oskiapps.shopsapp.engine.utils.ShopsappUtils;
import com.oskiapps.shopsapp.model.Auction;
import com.oskiapps.shopsapp.repository.AuctionRepository;
import com.oskiapps.shopsapp.serializer.PromotedAuctionSerializer;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

	private PromotedProductProperties properties;

	@Autowired
	AuctionRepository auctionRepository;

	public AuctionController(PromotedProductProperties properties) {
		super();
		this.properties = properties;
	}

	@GetMapping("/{id}")
	public Optional<Auction> getAuction(@PathVariable Long id) {
		return auctionRepository.findById(id);
	}

	@GetMapping("/get-all-auctions")
	public List<Auction> GetAllAuctions() {
		return auctionRepository.findAll();
	}

	@GetMapping(value = "/get-promoted-auctions", produces = { "application/JSON" })
	public String getPromotedAuctions2() {

		int descMaxLength = properties.getDescriptionMaxLength();
		int itemsMaxCount = properties.getItemsCount();
		PageRequest pageRequest = PageRequest.of(0, itemsMaxCount, new Sort(Direction.DESC, "promoted"));
		List<Auction> auctions = new LinkedList<Auction>(auctionRepository.findAll(pageRequest).getContent());
		List<Auction> selectedAuctions = new ArrayList<>();
		itemsMaxCount = itemsMaxCount > auctions.size() ? (int) auctions.size() : properties.getItemsCount();

		for (int i = 0; i < itemsMaxCount; i++) {
			RandomSelector auctionsSelector = new RandomSelector(auctions);
			selectedAuctions.add(auctionsSelector.getRandomAuction(auctions));
		}

		for (Auction auction : selectedAuctions) {
			if (auction.getDescriptionShort().length() > descMaxLength)
				auction.setDescriptionShort(
						ShopsappUtils.getShortenedText(auction.getDescriptionShort(), descMaxLength));
		}
		selectedAuctions = selectedAuctions.subList(0, itemsMaxCount);

		ObjectMapper mapper = new ObjectMapper();

		SimpleModule mod = new SimpleModule("PromotedAuction Module");

		mod.addSerializer(new PromotedAuctionSerializer(Auction.class));

		mapper.registerModule(mod);

		String json = null;

		try {
			json = mapper.writeValueAsString(selectedAuctions);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

	@JsonView(Auction.Views.AuctionForUserData.class)
	@GetMapping("/get-auction-for-user/{id}")
	public Auction getAuctionDataForUser(@PathVariable Long id) {
		return auctionRepository.getOne(id);
	}

}

package com.oskiapps.shopsapp.controllers;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.oskiapps.shopsapp.engine.config.properties.customer.AuctionsListProperties;
import com.oskiapps.shopsapp.engine.config.properties.customer.PromotedAuctionsProperties;
import com.oskiapps.shopsapp.engine.utils.RandomSelector;
import com.oskiapps.shopsapp.engine.utils.ShopsappUtils;
import com.oskiapps.shopsapp.model.auxiliaries.AbstractListData;
import com.oskiapps.shopsapp.model.auxiliaries.PaginationData;
import com.oskiapps.shopsapp.model.entities.Auction;
import com.oskiapps.shopsapp.repository.AuctionRepository;
import com.oskiapps.shopsapp.repository.specification.AuctionSpecs;
import com.oskiapps.shopsapp.serializer.AuctionListSerializer;
import com.oskiapps.shopsapp.serializer.PromotedAuctionSerializer;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

	@Autowired
	private PromotedAuctionsProperties promotedAuctionsProperties;

	@Autowired
	private AuctionsListProperties auctionsListProperties;

	@Autowired
	AuctionRepository auctionRepository;

	@GetMapping("/{id}")
	public Optional<Auction> getAuction(@PathVariable Long id) {
		return auctionRepository.findById(id);
	}

	@GetMapping("/get-all-auctions")
	public List<Auction> getAllAuctions() {
		return auctionRepository.findAll();
	}

	@GetMapping(value = "/get-auctions-by-category/{id}/{page}", produces = { "application/JSON" })
	public String getAuctionsByCategory(@PathVariable Long id, @PathVariable int page,
			@RequestParam(value = "priceSort", defaultValue = "") String priceSort,
			@RequestParam(value = "dateSort", defaultValue = "") String dateSort,
			@RequestParam(value = "priceFrom", defaultValue = "0") String priceFrom,
			@RequestParam(value = "priceTo", defaultValue = "0") String priceTo,
			@RequestParam(value = "dateFrom", defaultValue = "") String dateFrom,
			@RequestParam(value = "dateTo", defaultValue = "") String dateTo) {

		Optional<Direction> directionPriceSort = Direction.fromOptionalString(priceSort);
		Optional<Direction> directionDateSort = Direction.fromOptionalString(dateSort);
		Order orderPrice = new Order(directionPriceSort.orElse(null), "priceBrutto");
		Order orderDate = new Order(directionDateSort.orElse(null), "dateFrom");
		List<Order> orders = new ArrayList<Order>();
		if (!priceSort.equals(""))
			orders.add(orderPrice);
		if (!dateSort.equals(""))
			orders.add(orderDate);
		Pageable pageRequest = PageRequest.of(page, this.auctionsListProperties.getPageSize(), Sort.by(orders));

		boolean usedFilters = !priceFrom.equals("") || !priceFrom.equals("") || !priceFrom.equals("")
				|| !priceFrom.equals("");

		List<Auction> auctions = new LinkedList<Auction>();
		Specification<Auction> spec = null;
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date dFrom = null;
		Date dTo = null;
		try {
			if (!dateFrom.equals(""))
				dFrom = df.parse(dateFrom);
			if (!dateTo.equals(""))
				dTo = df.parse(dateTo);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (usedFilters) {
			spec = AuctionSpecs.categoryIs(id)
					.and(AuctionSpecs.priceBetween(new BigDecimal(priceFrom), new BigDecimal(priceTo))
							.and(AuctionSpecs.dateBetween(dFrom, dTo)));
			auctions = new LinkedList<Auction>(this.auctionRepository.findAll(spec, pageRequest).getContent());
		} else {
			auctions = new LinkedList<Auction>(
					this.auctionRepository.findAllByProductProductCategoryId(id, pageRequest).getContent());
		}

		AbstractListData listData = new AbstractListData();
		listData.setItems(auctions);
		PaginationData pd = this.getPaginationData();
		if (usedFilters)
			pd.setItemsCount((int) this.auctionRepository.count(spec));
		else
			pd.setItemsCount(this.auctionRepository.countByProductProductCategoryId(id));

		listData.setPaginationData(pd);

		ObjectMapper mapper = new ObjectMapper();
		SimpleModule mod = new SimpleModule("PromotedAuction Module");
		mod.addSerializer(new AuctionListSerializer(Auction.class));
		mapper.registerModule(mod);
		String json = null;
		try {
			json = mapper.writeValueAsString(listData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

	private PaginationData getPaginationData() {
		PaginationData pd = new PaginationData();
		pd.setPageSize(this.auctionsListProperties.getPageSize());
		pd.setAdjacentPages(this.auctionsListProperties.getPaginationAdjacentPages());
		pd.setShowArrows(this.auctionsListProperties.isPaginationShowArrows());
		return pd;
	}

	@GetMapping(value = "/get-promoted-auctions", produces = { "application/JSON" })
	public String getPromotedAuctions() {

		int nameMaxLength = promotedAuctionsProperties.getNameMaxLength();
		int descMaxLength = promotedAuctionsProperties.getDescriptionMaxLength();
		int itemsMaxCount = promotedAuctionsProperties.getItemsCount();
		PageRequest pageRequest = PageRequest.of(0, itemsMaxCount, Sort.by(Direction.DESC, "promoted"));
		List<Auction> auctions = new LinkedList<Auction>(auctionRepository.findAll(pageRequest).getContent());
		List<Auction> selectedAuctions = new ArrayList<>();
		itemsMaxCount = itemsMaxCount > auctions.size() ? (int) auctions.size()
				: promotedAuctionsProperties.getItemsCount();

		for (int i = 0; i < itemsMaxCount; i++) {
			RandomSelector auctionsSelector = new RandomSelector(auctions);
			selectedAuctions.add(auctionsSelector.getRandomAuction(auctions));
		}

		for (Auction auction : selectedAuctions) {
			if (auction.getName().length() > nameMaxLength)
				auction.setName(ShopsappUtils.getShortenedText(auction.getName(), nameMaxLength));
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

	@GetMapping("/get-auction-for-user/{id}")
	@JsonView(Auction.Views.AuctionForUserData.class)
	public Auction getAuctionDataForUser(@PathVariable Long id) {
		return auctionRepository.getOne(id);
	}

}

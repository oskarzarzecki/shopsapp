package com.oskiapps.shopsapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import com.oskiapps.shopsapp.model.Auction.Views.AuctionForUserData;

/**
 * The persistent class for the auction_delivery_option database table.
 * 
 */
@Entity
@Table(name = "auction_delivery_option")
@NamedQuery(name = "AuctionDeliveryOption.findAll", query = "SELECT a FROM AuctionDeliveryOption a")
public class AuctionDeliveryOption {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// bi-directional many-to-one association to Auction
	@ManyToOne
	private Auction auction;

	// bi-directional many-to-one association to DeliveryOption
	@ManyToOne
	@JoinColumn(name = "delivery_option_id")
	private DeliveryOption deliveryOption;

	public AuctionDeliveryOption() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	@JsonUnwrapped
	@JsonView(AuctionForUserData.class)
	public DeliveryOption getDeliveryOption() {
		return this.deliveryOption;
	}

	public void setDeliveryOption(DeliveryOption deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

}
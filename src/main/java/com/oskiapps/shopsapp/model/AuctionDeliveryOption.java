package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the auction_delivery_option database table.
 * 
 */
@Entity
@Table(name="auction_delivery_option")
@NamedQuery(name="AuctionDeliveryOption.findAll", query="SELECT a FROM AuctionDeliveryOption a")
public class AuctionDeliveryOption  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	//bi-directional many-to-one association to Auction
	@ManyToOne
	private Auction auction;

	//bi-directional many-to-one association to DeliveryOption
	@ManyToOne
	@JoinColumn(name="delivery_option_id")
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

	public DeliveryOption getDeliveryOption() {
		return this.deliveryOption;
	}

	public void setDeliveryOption(DeliveryOption deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

}
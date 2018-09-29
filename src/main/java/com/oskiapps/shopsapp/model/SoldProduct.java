package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sold_product database table.
 * 
 */
@Entity
@Table(name="sold_product")
@NamedQuery(name="SoldProduct.findAll", query="SELECT s FROM SoldProduct s")
public class SoldProduct  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="price_brutto")
	private BigDecimal priceBrutto;

	@Column(name="price_netto")
	private BigDecimal priceNetto;

	private int quanity;

	private BigDecimal size;

	//bi-directional many-to-one association to Auction
	@ManyToOne
	private Auction auction;

	//bi-directional many-to-one association to CustomerOrder
	@ManyToOne
	@JoinColumn(name="customer_order_id")
	private CustomerOrder customerOrder;

	public SoldProduct() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPriceBrutto() {
		return this.priceBrutto;
	}

	public void setPriceBrutto(BigDecimal priceBrutto) {
		this.priceBrutto = priceBrutto;
	}

	public BigDecimal getPriceNetto() {
		return this.priceNetto;
	}

	public void setPriceNetto(BigDecimal priceNetto) {
		this.priceNetto = priceNetto;
	}

	public int getQuanity() {
		return this.quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public BigDecimal getSize() {
		return this.size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public CustomerOrder getCustomerOrder() {
		return this.customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

}
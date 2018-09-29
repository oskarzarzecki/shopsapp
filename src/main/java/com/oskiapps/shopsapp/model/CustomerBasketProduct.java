package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the customer_basket_product database table.
 * 
 */
@Entity
@Table(name="customer_basket_product")
@NamedQuery(name="CustomerBasketProduct.findAll", query="SELECT c FROM CustomerBasketProduct c")
public class CustomerBasketProduct  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_added")
	private Date dateAdded;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	private int quanity;

	private BigDecimal size;

	//bi-directional many-to-one association to Auction
	@ManyToOne
	private Auction auction;

	//bi-directional many-to-one association to CustomerBasket
	@ManyToOne
	@JoinColumn(name="customer_basket_id")
	private CustomerBasket customerBasket;

	public CustomerBasketProduct() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateDeleted() {
		return this.dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
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

	public CustomerBasket getCustomerBasket() {
		return this.customerBasket;
	}

	public void setCustomerBasket(CustomerBasket customerBasket) {
		this.customerBasket = customerBasket;
	}

}
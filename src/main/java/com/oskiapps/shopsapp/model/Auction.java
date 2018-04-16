package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the auction database table.
 * 
 */
@Entity
@NamedQuery(name="Auction.findAll", query="SELECT a FROM Auction a")
public class Auction  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int active;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	@Temporal(TemporalType.DATE)
	@Column(name="date_from")
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="date_to")
	private Date dateTo;

	private int deleted;

	@Lob
	private String description;

	private String name;

	@Column(name="price_brutto")
	private BigDecimal priceBrutto;

	@Column(name="price_netto")
	private BigDecimal priceNetto;

	private int promoted;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to AuctionDeliveryOption
	@OneToMany(mappedBy="auction")
	private List<AuctionDeliveryOption> auctionDeliveryOptions;

	//bi-directional many-to-one association to CustomerBasketProduct
	@OneToMany(mappedBy="auction")
	private List<CustomerBasketProduct> customerBasketProducts;

	//bi-directional many-to-one association to SoldProduct
	@OneToMany(mappedBy="auction")
	private List<SoldProduct> soldProducts;

	public Auction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getAvailable() {
		return this.available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Date getDateDeleted() {
		return this.dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getPromoted() {
		return this.promoted;
	}

	public void setPromoted(int promoted) {
		this.promoted = promoted;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<AuctionDeliveryOption> getAuctionDeliveryOptions() {
		return this.auctionDeliveryOptions;
	}

	public void setAuctionDeliveryOptions(List<AuctionDeliveryOption> auctionDeliveryOptions) {
		this.auctionDeliveryOptions = auctionDeliveryOptions;
	}

	public AuctionDeliveryOption addAuctionDeliveryOption(AuctionDeliveryOption auctionDeliveryOption) {
		getAuctionDeliveryOptions().add(auctionDeliveryOption);
		auctionDeliveryOption.setAuction(this);

		return auctionDeliveryOption;
	}

	public AuctionDeliveryOption removeAuctionDeliveryOption(AuctionDeliveryOption auctionDeliveryOption) {
		getAuctionDeliveryOptions().remove(auctionDeliveryOption);
		auctionDeliveryOption.setAuction(null);

		return auctionDeliveryOption;
	}

	public List<CustomerBasketProduct> getCustomerBasketProducts() {
		return this.customerBasketProducts;
	}

	public void setCustomerBasketProducts(List<CustomerBasketProduct> customerBasketProducts) {
		this.customerBasketProducts = customerBasketProducts;
	}

	public CustomerBasketProduct addCustomerBasketProduct(CustomerBasketProduct customerBasketProduct) {
		getCustomerBasketProducts().add(customerBasketProduct);
		customerBasketProduct.setAuction(this);

		return customerBasketProduct;
	}

	public CustomerBasketProduct removeCustomerBasketProduct(CustomerBasketProduct customerBasketProduct) {
		getCustomerBasketProducts().remove(customerBasketProduct);
		customerBasketProduct.setAuction(null);

		return customerBasketProduct;
	}

	public List<SoldProduct> getSoldProducts() {
		return this.soldProducts;
	}

	public void setSoldProducts(List<SoldProduct> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public SoldProduct addSoldProduct(SoldProduct soldProduct) {
		getSoldProducts().add(soldProduct);
		soldProduct.setAuction(this);

		return soldProduct;
	}

	public SoldProduct removeSoldProduct(SoldProduct soldProduct) {
		getSoldProducts().remove(soldProduct);
		soldProduct.setAuction(null);

		return soldProduct;
	}

}
package com.oskiapps.shopsapp.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.oskiapps.shopsapp.model.entities.Auction.Views.AuctionForUserData;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_deleted")
	private Date dateDeleted;

	private int deleted;

	@Lob
	private String description;

	private String name;

	// bi-directional many-to-one association to Auction
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Auction> auctions;

	// bi-directional many-to-one association to CustomerFavoriteProduct
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<CustomerFavoriteProduct> customerFavoriteProducts;

	// bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;

	// bi-directional many-to-one association to VatRate
	@ManyToOne
	@JoinColumn(name = "vat_rate_id")
	private VatRate vatRate;

	// bi-directional many-to-one association to ProductPropertyValue
	@OneToMany(mappedBy = "product")
	private List<ProductPropertyValue> productPropertyValues;

	// bi-directional many-to-one association to ProductVariant
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<ProductVariant> productVariants;

	// bi-directional many-to-one association to StoredProduct
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<StoredProduct> storedProducts;

	public Product() {
	}

	@JsonView({ AuctionForUserData.class })
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	@JsonView(AuctionForUserData.class)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Auction> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}

	public Auction addAuction(Auction auction) {
		getAuctions().add(auction);
		auction.setProduct(this);

		return auction;
	}

	public Auction removeAuction(Auction auction) {
		getAuctions().remove(auction);
		auction.setProduct(null);

		return auction;
	}

	public List<CustomerFavoriteProduct> getCustomerFavoriteProducts() {
		return this.customerFavoriteProducts;
	}

	public void setCustomerFavoriteProducts(List<CustomerFavoriteProduct> customerFavoriteProducts) {
		this.customerFavoriteProducts = customerFavoriteProducts;
	}

	public CustomerFavoriteProduct addCustomerFavoriteProduct(CustomerFavoriteProduct customerFavoriteProduct) {
		getCustomerFavoriteProducts().add(customerFavoriteProduct);
		customerFavoriteProduct.setProduct(this);

		return customerFavoriteProduct;
	}

	public CustomerFavoriteProduct removeCustomerFavoriteProduct(CustomerFavoriteProduct customerFavoriteProduct) {
		getCustomerFavoriteProducts().remove(customerFavoriteProduct);
		customerFavoriteProduct.setProduct(null);

		return customerFavoriteProduct;
	}

	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public VatRate getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(VatRate vatRate) {
		this.vatRate = vatRate;
	}

	@JsonView(AuctionForUserData.class)
	public List<ProductPropertyValue> getProductPropertyValues() {
		return this.productPropertyValues;
	}

	public void setProductPropertyValues(List<ProductPropertyValue> productPropertyValues) {
		this.productPropertyValues = productPropertyValues;
	}

	public ProductPropertyValue addProductPropertyValue(ProductPropertyValue productPropertyValue) {
		getProductPropertyValues().add(productPropertyValue);
		productPropertyValue.setProduct(this);

		return productPropertyValue;
	}

	public ProductPropertyValue removeProductPropertyValue(ProductPropertyValue productPropertyValue) {
		getProductPropertyValues().remove(productPropertyValue);
		productPropertyValue.setProduct(null);

		return productPropertyValue;
	}

	@JsonView({ AuctionForUserData.class })
	public List<ProductVariant> getProductVariants() {
		return this.productVariants;
	}

	public void setProductVariants(List<ProductVariant> productVariants) {
		this.productVariants = productVariants;
	}

	public ProductVariant addProductVariant(ProductVariant productVariant) {
		getProductVariants().add(productVariant);
		productVariant.setProduct(this);

		return productVariant;
	}

	public ProductVariant removeProductVariant(ProductVariant productVariant) {
		getProductVariants().remove(productVariant);
		productVariant.setProduct(null);

		return productVariant;
	}

	public List<StoredProduct> getStoredProducts() {
		return this.storedProducts;
	}

	public void setStoredProducts(List<StoredProduct> storedProducts) {
		this.storedProducts = storedProducts;
	}

	public StoredProduct addStoredProduct(StoredProduct storedProduct) {
		getStoredProducts().add(storedProduct);
		storedProduct.setProduct(this);

		return storedProduct;
	}

	public StoredProduct removeStoredProduct(StoredProduct storedProduct) {
		getStoredProducts().remove(storedProduct);
		storedProduct.setProduct(null);

		return storedProduct;
	}

}
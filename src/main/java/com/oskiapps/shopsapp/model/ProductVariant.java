package com.oskiapps.shopsapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;
import com.oskiapps.shopsapp.model.Auction.Views.AuctionForUserData;

/**
 * The persistent class for the product_variant database table.
 * 
 */
@Entity
@Table(name = "product_variant")
@NamedQuery(name = "ProductVariant.findAll", query = "SELECT p FROM ProductVariant p")
public class ProductVariant {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_deleted")
	private Date dateDeleted;

	private int deleted;

	private String name;

	// bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy = "productVariant")
	private List<ProductImage> productImages;

	// bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	// bi-directional many-to-one association to ProductColor
	@ManyToOne
	@JoinColumn(name = "product_color_id")
	private ProductColor productColor;

	public ProductVariant() {
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

	@JsonView({ AuctionForUserData.class })
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonView({ AuctionForUserData.class })
	public List<ProductImage> getProductImages() {
		return this.productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public ProductImage addProductImage(ProductImage productImage) {
		getProductImages().add(productImage);
		productImage.setProductVariant(this);

		return productImage;
	}

	public ProductImage removeProductImage(ProductImage productImage) {
		getProductImages().remove(productImage);
		productImage.setProductVariant(null);

		return productImage;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductColor getProductColor() {
		return this.productColor;
	}

	public void setProductColor(ProductColor productColor) {
		this.productColor = productColor;
	}

}
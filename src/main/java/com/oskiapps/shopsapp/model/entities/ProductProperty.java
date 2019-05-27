package com.oskiapps.shopsapp.model.entities;

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

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import com.oskiapps.shopsapp.model.entities.Auction.Views.AuctionForUserData;

/**
 * The persistent class for the product_property database table.
 * 
 */
@Entity
@Table(name = "product_property")
@NamedQuery(name = "ProductProperty.findAll", query = "SELECT p FROM ProductProperty p")
public class ProductProperty {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_deleted")
	private Date dateDeleted;

	private int deleted;

	// bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;

	// bi-directional many-to-one association to ProductPropertyName
	@ManyToOne
	@JoinColumn(name = "product_property_name_id")
	private ProductPropertyName productPropertyName;

	// bi-directional many-to-one association to ProductPropertyImage
	@OneToMany(mappedBy = "productProperty")
	private List<ProductPropertyImage> productPropertyImages;

	// bi-directional many-to-one association to ProductPropertyValue
	@OneToMany(mappedBy = "productProperty")
	private List<ProductPropertyValue> productPropertyValues;

	public ProductProperty() {
	}

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

	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@JsonUnwrapped
	@JsonView(AuctionForUserData.class)
	public ProductPropertyName getProductPropertyName() {
		return this.productPropertyName;
	}

	public void setProductPropertyName(ProductPropertyName productPropertyName) {
		this.productPropertyName = productPropertyName;
	}

	public List<ProductPropertyImage> getProductPropertyImages() {
		return this.productPropertyImages;
	}

	public void setProductPropertyImages(List<ProductPropertyImage> productPropertyImages) {
		this.productPropertyImages = productPropertyImages;
	}

	public ProductPropertyImage addProductPropertyImage(ProductPropertyImage productPropertyImage) {
		getProductPropertyImages().add(productPropertyImage);
		productPropertyImage.setProductProperty(this);

		return productPropertyImage;
	}

	public ProductPropertyImage removeProductPropertyImage(ProductPropertyImage productPropertyImage) {
		getProductPropertyImages().remove(productPropertyImage);
		productPropertyImage.setProductProperty(null);

		return productPropertyImage;
	}

	public List<ProductPropertyValue> getProductPropertyValues() {
		return this.productPropertyValues;
	}

	public void setProductPropertyValues(List<ProductPropertyValue> productPropertyValues) {
		this.productPropertyValues = productPropertyValues;
	}

	public ProductPropertyValue addProductPropertyValue(ProductPropertyValue productPropertyValue) {
		getProductPropertyValues().add(productPropertyValue);
		productPropertyValue.setProductProperty(this);

		return productPropertyValue;
	}

	public ProductPropertyValue removeProductPropertyValue(ProductPropertyValue productPropertyValue) {
		getProductPropertyValues().remove(productPropertyValue);
		productPropertyValue.setProductProperty(null);

		return productPropertyValue;
	}

}
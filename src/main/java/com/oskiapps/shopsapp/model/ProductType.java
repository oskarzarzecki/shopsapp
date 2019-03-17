package com.oskiapps.shopsapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.oskiapps.shopsapp.model.ProductType.Views.AllProductTypesWithCategories;

/**
 * The persistent class for the product_type database table.
 * 
 */
@Entity
@Table(name = "product_type")
@NamedQuery(name = "ProductType.findAll", query = "SELECT p FROM ProductType p")
public class ProductType {

	public static class Views {
		public interface AllProductTypesWithCategories {
		}
	};

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

	// bi-directional many-to-one association to ProductCategory
	@OneToMany(mappedBy = "productType")
	@JsonIgnore
	private List<ProductCategory> productCategories;

	// bi-directional many-to-one association to ProductTypeImage
	@OneToMany(mappedBy = "productType")
	@JsonIgnore
	private List<ProductTypeImage> productTypeImages;

	public ProductType() {
	}

	@JsonView(AllProductTypesWithCategories.class)
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

	@JsonView(AllProductTypesWithCategories.class)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonView(AllProductTypesWithCategories.class)
	public List<ProductCategory> getProductCategories() {
		return this.productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

	public ProductCategory addProductCategory(ProductCategory productCategory) {
		getProductCategories().add(productCategory);
		productCategory.setProductType(this);

		return productCategory;
	}

	public ProductCategory removeProductCategory(ProductCategory productCategory) {
		getProductCategories().remove(productCategory);
		productCategory.setProductType(null);

		return productCategory;
	}

	public List<ProductTypeImage> getProductTypeImages() {
		return this.productTypeImages;
	}

	public void setProductTypeImages(List<ProductTypeImage> productTypeImages) {
		this.productTypeImages = productTypeImages;
	}

	public ProductTypeImage addProductTypeImage(ProductTypeImage productTypeImage) {
		getProductTypeImages().add(productTypeImage);
		productTypeImage.setProductType(this);

		return productTypeImage;
	}

	public ProductTypeImage removeProductTypeImage(ProductTypeImage productTypeImage) {
		getProductTypeImages().remove(productTypeImage);
		productTypeImage.setProductType(null);

		return productTypeImage;
	}

}
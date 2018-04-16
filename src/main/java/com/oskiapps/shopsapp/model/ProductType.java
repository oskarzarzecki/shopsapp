package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product_type database table.
 * 
 */
@Entity
@Table(name="product_type")
@NamedQuery(name="ProductType.findAll", query="SELECT p FROM ProductType p")
public class ProductType  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to ProductCategory
	@OneToMany(mappedBy="productType")
	private List<ProductCategory> productCategories;

	//bi-directional many-to-one association to ProductTypeImage
	@OneToMany(mappedBy="productType")
	private List<ProductTypeImage> productTypeImages;

	public ProductType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
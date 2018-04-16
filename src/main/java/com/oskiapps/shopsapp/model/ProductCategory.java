package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Table(name="product_category")
@NamedQuery(name="ProductCategory.findAll", query="SELECT p FROM ProductCategory p")
public class ProductCategory  {
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

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productCategory")
	private List<Product> products;

	//bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name="product_type_id")
	private ProductType productType;

	//bi-directional many-to-one association to ProductCategoryImage
	@OneToMany(mappedBy="productCategory")
	private List<ProductCategoryImage> productCategoryImages;

	public ProductCategory() {
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

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductCategory(null);

		return product;
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public List<ProductCategoryImage> getProductCategoryImages() {
		return this.productCategoryImages;
	}

	public void setProductCategoryImages(List<ProductCategoryImage> productCategoryImages) {
		this.productCategoryImages = productCategoryImages;
	}

	public ProductCategoryImage addProductCategoryImage(ProductCategoryImage productCategoryImage) {
		getProductCategoryImages().add(productCategoryImage);
		productCategoryImage.setProductCategory(this);

		return productCategoryImage;
	}

	public ProductCategoryImage removeProductCategoryImage(ProductCategoryImage productCategoryImage) {
		getProductCategoryImages().remove(productCategoryImage);
		productCategoryImage.setProductCategory(null);

		return productCategoryImage;
	}

}
package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product_variant database table.
 * 
 */
@Entity
@Table(name="product_variant")
@NamedQuery(name="ProductVariant.findAll", query="SELECT p FROM ProductVariant p")
public class ProductVariant  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	private String name;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="productVariant")
	private List<ProductImage> productImages;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to ProductColor
	@ManyToOne
	@JoinColumn(name="product_color_id")
	private ProductColor productColor;

	public ProductVariant() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product_color database table.
 * 
 */
@Entity
@Table(name="product_color")
@NamedQuery(name="ProductColor.findAll", query="SELECT p FROM ProductColor p")
public class ProductColor  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	private String name;

	//bi-directional many-to-one association to ProductVariant
	@OneToMany(mappedBy="productColor")
	private List<ProductVariant> productVariants;

	public ProductColor() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductVariant> getProductVariants() {
		return this.productVariants;
	}

	public void setProductVariants(List<ProductVariant> productVariants) {
		this.productVariants = productVariants;
	}

	public ProductVariant addProductVariant(ProductVariant productVariant) {
		getProductVariants().add(productVariant);
		productVariant.setProductColor(this);

		return productVariant;
	}

	public ProductVariant removeProductVariant(ProductVariant productVariant) {
		getProductVariants().remove(productVariant);
		productVariant.setProductColor(null);

		return productVariant;
	}

}
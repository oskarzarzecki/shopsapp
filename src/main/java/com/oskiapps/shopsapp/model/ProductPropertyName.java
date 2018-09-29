package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product_property_name database table.
 * 
 */
@Entity
@Table(name="product_property_name")
@NamedQuery(name="ProductPropertyName.findAll", query="SELECT p FROM ProductPropertyName p")
public class ProductPropertyName  {
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

	//bi-directional many-to-one association to ProductProperty
	@OneToMany(mappedBy="productPropertyName")
	private List<ProductProperty> productProperties;

	public ProductPropertyName() {
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

	public List<ProductProperty> getProductProperties() {
		return this.productProperties;
	}

	public void setProductProperties(List<ProductProperty> productProperties) {
		this.productProperties = productProperties;
	}

	public ProductProperty addProductProperty(ProductProperty productProperty) {
		getProductProperties().add(productProperty);
		productProperty.setProductPropertyName(this);

		return productProperty;
	}

	public ProductProperty removeProductProperty(ProductProperty productProperty) {
		getProductProperties().remove(productProperty);
		productProperty.setProductPropertyName(null);

		return productProperty;
	}

}
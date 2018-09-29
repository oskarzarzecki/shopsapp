package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product_property_image database table.
 * 
 */
@Entity
@Table(name="product_property_image")
@NamedQuery(name="ProductPropertyImage.findAll", query="SELECT p FROM ProductPropertyImage p")
public class ProductPropertyImage  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	@Lob
	private String path;

	//bi-directional many-to-one association to ProductProperty
	@ManyToOne
	@JoinColumn(name="property_id")
	private ProductProperty productProperty;

	public ProductPropertyImage() {
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ProductProperty getProductProperty() {
		return this.productProperty;
	}

	public void setProductProperty(ProductProperty productProperty) {
		this.productProperty = productProperty;
	}

}
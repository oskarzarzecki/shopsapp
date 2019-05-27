package com.oskiapps.shopsapp.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the stored_product database table.
 * 
 */
@Entity
@Table(name="stored_product")
@NamedQuery(name="StoredProduct.findAll", query="SELECT s FROM StoredProduct s")
public class StoredProduct  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	private int quanity;

	private BigDecimal size;

	//bi-directional many-to-one association to Place
	@ManyToOne
	private Place place;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public StoredProduct() {
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

	public int getQuanity() {
		return this.quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public BigDecimal getSize() {
		return this.size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
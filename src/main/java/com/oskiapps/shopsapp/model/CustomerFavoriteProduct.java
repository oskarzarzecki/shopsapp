package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the customer_favorite_product database table.
 * 
 */
@Entity
@Table(name="customer_favorite_product")
@NamedQuery(name="CustomerFavoriteProduct.findAll", query="SELECT c FROM CustomerFavoriteProduct c")
public class CustomerFavoriteProduct  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_added")
	private Date dateAdded;

	private int deleted;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="customer_account_id")
	private CustomerAccount customerAccount;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public CustomerFavoriteProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public CustomerAccount getCustomerAccount() {
		return this.customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
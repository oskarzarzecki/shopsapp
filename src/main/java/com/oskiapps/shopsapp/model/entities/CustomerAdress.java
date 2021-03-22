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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the customer_adress database table.
 * 
 */
@Entity
@Table(name = "customer_adress")
@NamedQuery(name = "CustomerAdress.findAll", query = "SELECT c FROM CustomerAdress c")
public class CustomerAdress {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_deleted")
	private Date dateDeleted;

	private int deleted;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "postal_code")
	private String postalCode;

	private String street;

	// bi-directional many-to-one association to City
	@ManyToOne
	private City city;

	// bi-directional many-to-one association to CustomerAccount
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_account_id")
	private CustomerAccount customerAccount;

	// bi-directional many-to-one association to CustomerOrder
	@JsonIgnore
	@OneToMany(mappedBy = "customerAdress")
	private List<CustomerOrder> customerOrders;

	public CustomerAdress() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public CustomerAccount getCustomerAccount() {
		return this.customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public List<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().add(customerOrder);
		customerOrder.setCustomerAdress(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().remove(customerOrder);
		customerOrder.setCustomerAdress(null);

		return customerOrder;
	}

}
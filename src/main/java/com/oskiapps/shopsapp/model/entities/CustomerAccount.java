package com.oskiapps.shopsapp.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * The persistent class for the customer_account database table.
 * 
 */
@Entity
@Table(name = "customer_account")
@NamedQuery(name = "CustomerAccount.findAll", query = "SELECT c FROM CustomerAccount c")
public class CustomerAccount {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_deleted")
	private Date dateDeleted;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_from")
	private Date dateFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_to")
	private Date dateTo;

	private int deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_visit")
	private Date lastVisit;

	private int online;

	@NotBlank(message = "incorrect password")
	@Column(name = "password_hash")
	private String passwordHash;

	@Email(message = "incorrect email")
	@Size(min = 5, max = 200, message = "incorrect email")
	@Column(name = "email")
	private String email;

	// bi-directional many-to-one association to CustomerAdress
	@OneToMany(mappedBy = "customerAccount")
	private List<CustomerAdress> customerAdresses;

	// bi-directional many-to-one association to CustomerBasket
	@OneToMany(mappedBy = "customerAccount")
	private List<CustomerBasket> customerBaskets;

	// bi-directional many-to-one association to CustomerFavoriteProduct
	@OneToMany(mappedBy = "customerAccount")
	private List<CustomerFavoriteProduct> customerFavoriteProducts;

	// bi-directional many-to-one association to CustomerLogin
	@OneToMany(mappedBy = "customerAccount")
	private List<CustomerLogin> customerLogins;

	public CustomerAccount() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getDateDeleted() {
		return this.dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Date getLastVisit() {
		return this.lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public int getOnline() {
		return this.online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CustomerAdress> getCustomerAdresses() {
		return this.customerAdresses;
	}

	public void setCustomerAdresses(List<CustomerAdress> customerAdresses) {
		this.customerAdresses = customerAdresses;
	}

	public CustomerAdress addCustomerAdress(CustomerAdress customerAdress) {
		getCustomerAdresses().add(customerAdress);
		customerAdress.setCustomerAccount(this);

		return customerAdress;
	}

	public CustomerAdress removeCustomerAdress(CustomerAdress customerAdress) {
		getCustomerAdresses().remove(customerAdress);
		customerAdress.setCustomerAccount(null);

		return customerAdress;
	}

	public List<CustomerBasket> getCustomerBaskets() {
		return this.customerBaskets;
	}

	public void setCustomerBaskets(List<CustomerBasket> customerBaskets) {
		this.customerBaskets = customerBaskets;
	}

	public CustomerBasket addCustomerBasket(CustomerBasket customerBasket) {
		getCustomerBaskets().add(customerBasket);
		customerBasket.setCustomerAccount(this);

		return customerBasket;
	}

	public CustomerBasket removeCustomerBasket(CustomerBasket customerBasket) {
		getCustomerBaskets().remove(customerBasket);
		customerBasket.setCustomerAccount(null);

		return customerBasket;
	}

	public List<CustomerFavoriteProduct> getCustomerFavoriteProducts() {
		return this.customerFavoriteProducts;
	}

	public void setCustomerFavoriteProducts(List<CustomerFavoriteProduct> customerFavoriteProducts) {
		this.customerFavoriteProducts = customerFavoriteProducts;
	}

	public CustomerFavoriteProduct addCustomerFavoriteProduct(CustomerFavoriteProduct customerFavoriteProduct) {
		getCustomerFavoriteProducts().add(customerFavoriteProduct);
		customerFavoriteProduct.setCustomerAccount(this);

		return customerFavoriteProduct;
	}

	public CustomerFavoriteProduct removeCustomerFavoriteProduct(CustomerFavoriteProduct customerFavoriteProduct) {
		getCustomerFavoriteProducts().remove(customerFavoriteProduct);
		customerFavoriteProduct.setCustomerAccount(null);

		return customerFavoriteProduct;
	}

	public List<CustomerLogin> getCustomerLogins() {
		return this.customerLogins;
	}

	public void setCustomerLogins(List<CustomerLogin> customerLogins) {
		this.customerLogins = customerLogins;
	}

	public CustomerLogin addCustomerLogin(CustomerLogin customerLogin) {
		getCustomerLogins().add(customerLogin);
		customerLogin.setCustomerAccount(this);

		return customerLogin;
	}

	public CustomerLogin removeCustomerLogin(CustomerLogin customerLogin) {
		getCustomerLogins().remove(customerLogin);
		customerLogin.setCustomerAccount(null);

		return customerLogin;
	}

}
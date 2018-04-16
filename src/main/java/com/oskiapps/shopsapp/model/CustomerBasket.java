package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer_basket database table.
 * 
 */
@Entity
@Table(name="customer_basket")
@NamedQuery(name="CustomerBasket.findAll", query="SELECT c FROM CustomerBasket c")
public class CustomerBasket  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int history;

	private int sold;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne
	@JoinColumn(name="customer_account_id")
	private CustomerAccount customerAccount;

	//bi-directional many-to-one association to CustomerBasketProduct
	@OneToMany(mappedBy="customerBasket")
	private List<CustomerBasketProduct> customerBasketProducts;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="customerBasket")
	private List<CustomerOrder> customerOrders;

	public CustomerBasket() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHistory() {
		return this.history;
	}

	public void setHistory(int history) {
		this.history = history;
	}

	public int getSold() {
		return this.sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public CustomerAccount getCustomerAccount() {
		return this.customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public List<CustomerBasketProduct> getCustomerBasketProducts() {
		return this.customerBasketProducts;
	}

	public void setCustomerBasketProducts(List<CustomerBasketProduct> customerBasketProducts) {
		this.customerBasketProducts = customerBasketProducts;
	}

	public CustomerBasketProduct addCustomerBasketProduct(CustomerBasketProduct customerBasketProduct) {
		getCustomerBasketProducts().add(customerBasketProduct);
		customerBasketProduct.setCustomerBasket(this);

		return customerBasketProduct;
	}

	public CustomerBasketProduct removeCustomerBasketProduct(CustomerBasketProduct customerBasketProduct) {
		getCustomerBasketProducts().remove(customerBasketProduct);
		customerBasketProduct.setCustomerBasket(null);

		return customerBasketProduct;
	}

	public List<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().add(customerOrder);
		customerOrder.setCustomerBasket(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().remove(customerOrder);
		customerOrder.setCustomerBasket(null);

		return customerOrder;
	}

}
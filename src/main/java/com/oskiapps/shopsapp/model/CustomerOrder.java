package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer_order database table.
 * 
 */
@Entity
@Table(name="customer_order")
@NamedQuery(name="CustomerOrder.findAll", query="SELECT c FROM CustomerOrder c")
public class CustomerOrder  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_ordered")
	private Date dateOrdered;

	@Temporal(TemporalType.DATE)
	@Column(name="date_paid")
	private Date datePaid;

	private int paid;

	@Column(name="price_brutto")
	private BigDecimal priceBrutto;

	@Column(name="price_netto")
	private BigDecimal priceNetto;

	//bi-directional many-to-one association to CustomerAdress
	@ManyToOne
	@JoinColumn(name="customer_adress_id")
	private CustomerAdress customerAdress;

	//bi-directional many-to-one association to CustomerBasket
	@ManyToOne
	@JoinColumn(name="customer_basket_id")
	private CustomerBasket customerBasket;

	//bi-directional many-to-one association to DeliveryOption
	@ManyToOne
	@JoinColumn(name="delivery_option_id")
	private DeliveryOption deliveryOption;

	//bi-directional many-to-one association to Place
	@ManyToOne
	private Place place;

	//bi-directional many-to-one association to OrderStatusDate
	@OneToMany(mappedBy="customerOrder")
	private List<OrderStatusDate> orderStatusDates;

	//bi-directional many-to-one association to SoldProduct
	@OneToMany(mappedBy="customerOrder")
	private List<SoldProduct> soldProducts;

	public CustomerOrder() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateOrdered() {
		return this.dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public Date getDatePaid() {
		return this.datePaid;
	}

	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	public int getPaid() {
		return this.paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public BigDecimal getPriceBrutto() {
		return this.priceBrutto;
	}

	public void setPriceBrutto(BigDecimal priceBrutto) {
		this.priceBrutto = priceBrutto;
	}

	public BigDecimal getPriceNetto() {
		return this.priceNetto;
	}

	public void setPriceNetto(BigDecimal priceNetto) {
		this.priceNetto = priceNetto;
	}

	public CustomerAdress getCustomerAdress() {
		return this.customerAdress;
	}

	public void setCustomerAdress(CustomerAdress customerAdress) {
		this.customerAdress = customerAdress;
	}

	public CustomerBasket getCustomerBasket() {
		return this.customerBasket;
	}

	public void setCustomerBasket(CustomerBasket customerBasket) {
		this.customerBasket = customerBasket;
	}

	public DeliveryOption getDeliveryOption() {
		return this.deliveryOption;
	}

	public void setDeliveryOption(DeliveryOption deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<OrderStatusDate> getOrderStatusDates() {
		return this.orderStatusDates;
	}

	public void setOrderStatusDates(List<OrderStatusDate> orderStatusDates) {
		this.orderStatusDates = orderStatusDates;
	}

	public OrderStatusDate addOrderStatusDate(OrderStatusDate orderStatusDate) {
		getOrderStatusDates().add(orderStatusDate);
		orderStatusDate.setCustomerOrder(this);

		return orderStatusDate;
	}

	public OrderStatusDate removeOrderStatusDate(OrderStatusDate orderStatusDate) {
		getOrderStatusDates().remove(orderStatusDate);
		orderStatusDate.setCustomerOrder(null);

		return orderStatusDate;
	}

	public List<SoldProduct> getSoldProducts() {
		return this.soldProducts;
	}

	public void setSoldProducts(List<SoldProduct> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public SoldProduct addSoldProduct(SoldProduct soldProduct) {
		getSoldProducts().add(soldProduct);
		soldProduct.setCustomerOrder(this);

		return soldProduct;
	}

	public SoldProduct removeSoldProduct(SoldProduct soldProduct) {
		getSoldProducts().remove(soldProduct);
		soldProduct.setCustomerOrder(null);

		return soldProduct;
	}

}
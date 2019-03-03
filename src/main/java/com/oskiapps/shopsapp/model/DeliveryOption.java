package com.oskiapps.shopsapp.model;

import java.math.BigDecimal;
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

import com.fasterxml.jackson.annotation.JsonView;
import com.oskiapps.shopsapp.model.Auction.Views.AuctionForUserData;

/**
 * The persistent class for the delivery_option database table.
 * 
 */
@Entity
@Table(name = "delivery_option")
@NamedQuery(name = "DeliveryOption.findAll", query = "SELECT d FROM DeliveryOption d")
public class DeliveryOption {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_deleted")
	private Date dateDeleted;

	private int deleted;

	private String name;

	private BigDecimal price;

	@Column(name = "time_from")
	private int timeFrom;

	@Column(name = "time_to")
	private int timeTo;

	// bi-directional many-to-one association to AuctionDeliveryOption
	@OneToMany(mappedBy = "deliveryOption")
	private List<AuctionDeliveryOption> auctionDeliveryOptions;

	// bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy = "deliveryOption")
	private List<CustomerOrder> customerOrders;

	// bi-directional many-to-one association to PaymentOption
	@ManyToOne
	@JoinColumn(name = "payment_option_id")
	@JsonView(AuctionForUserData.class)
	private PaymentOption paymentOption;

	public DeliveryOption() {
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

	@JsonView(AuctionForUserData.class)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonView(AuctionForUserData.class)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@JsonView(AuctionForUserData.class)
	public int getTimeFrom() {
		return this.timeFrom;
	}

	public void setTimeFrom(int timeFrom) {
		this.timeFrom = timeFrom;
	}

	@JsonView(AuctionForUserData.class)
	public int getTimeTo() {
		return this.timeTo;
	}

	public void setTimeTo(int timeTo) {
		this.timeTo = timeTo;
	}

	public List<AuctionDeliveryOption> getAuctionDeliveryOptions() {
		return this.auctionDeliveryOptions;
	}

	public void setAuctionDeliveryOptions(List<AuctionDeliveryOption> auctionDeliveryOptions) {
		this.auctionDeliveryOptions = auctionDeliveryOptions;
	}

	public AuctionDeliveryOption addAuctionDeliveryOption(AuctionDeliveryOption auctionDeliveryOption) {
		getAuctionDeliveryOptions().add(auctionDeliveryOption);
		auctionDeliveryOption.setDeliveryOption(this);

		return auctionDeliveryOption;
	}

	public AuctionDeliveryOption removeAuctionDeliveryOption(AuctionDeliveryOption auctionDeliveryOption) {
		getAuctionDeliveryOptions().remove(auctionDeliveryOption);
		auctionDeliveryOption.setDeliveryOption(null);

		return auctionDeliveryOption;
	}

	public List<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().add(customerOrder);
		customerOrder.setDeliveryOption(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().remove(customerOrder);
		customerOrder.setDeliveryOption(null);

		return customerOrder;
	}

	public PaymentOption getPaymentOption() {
		return this.paymentOption;
	}

	public void setPaymentOption(PaymentOption paymentOption) {
		this.paymentOption = paymentOption;
	}

}
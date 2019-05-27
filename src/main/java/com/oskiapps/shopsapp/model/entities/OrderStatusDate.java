package com.oskiapps.shopsapp.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the order_status_date database table.
 * 
 */
@Entity
@Table(name="order_status_date")
@NamedQuery(name="OrderStatusDate.findAll", query="SELECT o FROM OrderStatusDate o")
public class OrderStatusDate  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_changed")
	private Date dateChanged;

	//bi-directional many-to-one association to CustomerOrder
	@ManyToOne
	@JoinColumn(name="customer_order_id")
	private CustomerOrder customerOrder;

	//bi-directional many-to-one association to OrderStatus
	@ManyToOne
	@JoinColumn(name="order_status_id")
	private OrderStatus orderStatus;

	public OrderStatusDate() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public CustomerOrder getCustomerOrder() {
		return this.customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
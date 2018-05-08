package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order_status database table.
 * 
 */
@Entity
@Table(name="order_status")
@NamedQuery(name="OrderStatus.findAll", query="SELECT o FROM OrderStatus o")
public class OrderStatus  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	private String name;

	//bi-directional many-to-one association to OrderStatusDate
	@OneToMany(mappedBy="orderStatus")
	private List<OrderStatusDate> orderStatusDates;

	public OrderStatus() {
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

	public List<OrderStatusDate> getOrderStatusDates() {
		return this.orderStatusDates;
	}

	public void setOrderStatusDates(List<OrderStatusDate> orderStatusDates) {
		this.orderStatusDates = orderStatusDates;
	}

	public OrderStatusDate addOrderStatusDate(OrderStatusDate orderStatusDate) {
		getOrderStatusDates().add(orderStatusDate);
		orderStatusDate.setOrderStatus(this);

		return orderStatusDate;
	}

	public OrderStatusDate removeOrderStatusDate(OrderStatusDate orderStatusDate) {
		getOrderStatusDates().remove(orderStatusDate);
		orderStatusDate.setOrderStatus(null);

		return orderStatusDate;
	}

}
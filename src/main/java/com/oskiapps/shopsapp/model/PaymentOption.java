package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the payment_option database table.
 * 
 */
@Entity
@Table(name="payment_option")
@NamedQuery(name="PaymentOption.findAll", query="SELECT p FROM PaymentOption p")
public class PaymentOption  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int available;

	private int cod;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	private String name;

	//bi-directional many-to-one association to DeliveryOption
	@OneToMany(mappedBy="paymentOption")
	private List<DeliveryOption> deliveryOptions;

	public PaymentOption() {
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

	public int getCod() {
		return this.cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
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

	public List<DeliveryOption> getDeliveryOptions() {
		return this.deliveryOptions;
	}

	public void setDeliveryOptions(List<DeliveryOption> deliveryOptions) {
		this.deliveryOptions = deliveryOptions;
	}

	public DeliveryOption addDeliveryOption(DeliveryOption deliveryOption) {
		getDeliveryOptions().add(deliveryOption);
		deliveryOption.setPaymentOption(this);

		return deliveryOption;
	}

	public DeliveryOption removeDeliveryOption(DeliveryOption deliveryOption) {
		getDeliveryOptions().remove(deliveryOption);
		deliveryOption.setPaymentOption(null);

		return deliveryOption;
	}

}
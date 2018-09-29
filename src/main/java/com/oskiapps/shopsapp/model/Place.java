package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the place database table.
 * 
 */
@Entity
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
public class Place  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	private String email;

	private String name;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="postal_code")
	private String postalCode;

	private String street;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="place")
	private List<CustomerOrder> customerOrders;

	//bi-directional many-to-one association to EmployeePlaceAccess
	@OneToMany(mappedBy="place")
	private List<EmployeePlaceAccess> employeePlaceAccesses;

	//bi-directional many-to-one association to EmploymentHistory
	@OneToMany(mappedBy="place")
	private List<EmploymentHistory> employmentHistories;

	//bi-directional many-to-one association to City
	@ManyToOne
	private City city;

	//bi-directional many-to-one association to PlaceTypeAssign
	@OneToMany(mappedBy="place")
	private List<PlaceTypeAssign> placeTypeAssigns;

	//bi-directional many-to-one association to StoredProduct
	@OneToMany(mappedBy="place")
	private List<StoredProduct> storedProducts;

	public Place() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().add(customerOrder);
		customerOrder.setPlace(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().remove(customerOrder);
		customerOrder.setPlace(null);

		return customerOrder;
	}

	public List<EmployeePlaceAccess> getEmployeePlaceAccesses() {
		return this.employeePlaceAccesses;
	}

	public void setEmployeePlaceAccesses(List<EmployeePlaceAccess> employeePlaceAccesses) {
		this.employeePlaceAccesses = employeePlaceAccesses;
	}

	public EmployeePlaceAccess addEmployeePlaceAccess(EmployeePlaceAccess employeePlaceAccess) {
		getEmployeePlaceAccesses().add(employeePlaceAccess);
		employeePlaceAccess.setPlace(this);

		return employeePlaceAccess;
	}

	public EmployeePlaceAccess removeEmployeePlaceAccess(EmployeePlaceAccess employeePlaceAccess) {
		getEmployeePlaceAccesses().remove(employeePlaceAccess);
		employeePlaceAccess.setPlace(null);

		return employeePlaceAccess;
	}

	public List<EmploymentHistory> getEmploymentHistories() {
		return this.employmentHistories;
	}

	public void setEmploymentHistories(List<EmploymentHistory> employmentHistories) {
		this.employmentHistories = employmentHistories;
	}

	public EmploymentHistory addEmploymentHistory(EmploymentHistory employmentHistory) {
		getEmploymentHistories().add(employmentHistory);
		employmentHistory.setPlace(this);

		return employmentHistory;
	}

	public EmploymentHistory removeEmploymentHistory(EmploymentHistory employmentHistory) {
		getEmploymentHistories().remove(employmentHistory);
		employmentHistory.setPlace(null);

		return employmentHistory;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<PlaceTypeAssign> getPlaceTypeAssigns() {
		return this.placeTypeAssigns;
	}

	public void setPlaceTypeAssigns(List<PlaceTypeAssign> placeTypeAssigns) {
		this.placeTypeAssigns = placeTypeAssigns;
	}

	public PlaceTypeAssign addPlaceTypeAssign(PlaceTypeAssign placeTypeAssign) {
		getPlaceTypeAssigns().add(placeTypeAssign);
		placeTypeAssign.setPlace(this);

		return placeTypeAssign;
	}

	public PlaceTypeAssign removePlaceTypeAssign(PlaceTypeAssign placeTypeAssign) {
		getPlaceTypeAssigns().remove(placeTypeAssign);
		placeTypeAssign.setPlace(null);

		return placeTypeAssign;
	}

	public List<StoredProduct> getStoredProducts() {
		return this.storedProducts;
	}

	public void setStoredProducts(List<StoredProduct> storedProducts) {
		this.storedProducts = storedProducts;
	}

	public StoredProduct addStoredProduct(StoredProduct storedProduct) {
		getStoredProducts().add(storedProduct);
		storedProduct.setPlace(this);

		return storedProduct;
	}

	public StoredProduct removeStoredProduct(StoredProduct storedProduct) {
		getStoredProducts().remove(storedProduct);
		storedProduct.setPlace(null);

		return storedProduct;
	}

}
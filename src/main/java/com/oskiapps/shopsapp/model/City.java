package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String name;

	private String region;

	//bi-directional many-to-one association to Country
	@ManyToOne
	private Country country;

	//bi-directional many-to-one association to CustomerAdress
	@OneToMany(mappedBy="city")
	private List<CustomerAdress> customerAdresses;

	//bi-directional many-to-one association to Place
	@OneToMany(mappedBy="city")
	private List<Place> places;

	public City() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<CustomerAdress> getCustomerAdresses() {
		return this.customerAdresses;
	}

	public void setCustomerAdresses(List<CustomerAdress> customerAdresses) {
		this.customerAdresses = customerAdresses;
	}

	public CustomerAdress addCustomerAdress(CustomerAdress customerAdress) {
		getCustomerAdresses().add(customerAdress);
		customerAdress.setCity(this);

		return customerAdress;
	}

	public CustomerAdress removeCustomerAdress(CustomerAdress customerAdress) {
		getCustomerAdresses().remove(customerAdress);
		customerAdress.setCity(null);

		return customerAdress;
	}

	public List<Place> getPlaces() {
		return this.places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public Place addPlace(Place place) {
		getPlaces().add(place);
		place.setCity(this);

		return place;
	}

	public Place removePlace(Place place) {
		getPlaces().remove(place);
		place.setCity(null);

		return place;
	}

}
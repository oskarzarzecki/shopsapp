package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the place_type database table.
 * 
 */
@Entity
@Table(name="place_type")
@NamedQuery(name="PlaceType.findAll", query="SELECT p FROM PlaceType p")
public class PlaceType  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to PlaceTypeAssign
	@OneToMany(mappedBy="placeType")
	private List<PlaceTypeAssign> placeTypeAssigns;

	public PlaceType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PlaceTypeAssign> getPlaceTypeAssigns() {
		return this.placeTypeAssigns;
	}

	public void setPlaceTypeAssigns(List<PlaceTypeAssign> placeTypeAssigns) {
		this.placeTypeAssigns = placeTypeAssigns;
	}

	public PlaceTypeAssign addPlaceTypeAssign(PlaceTypeAssign placeTypeAssign) {
		getPlaceTypeAssigns().add(placeTypeAssign);
		placeTypeAssign.setPlaceType(this);

		return placeTypeAssign;
	}

	public PlaceTypeAssign removePlaceTypeAssign(PlaceTypeAssign placeTypeAssign) {
		getPlaceTypeAssigns().remove(placeTypeAssign);
		placeTypeAssign.setPlaceType(null);

		return placeTypeAssign;
	}

}
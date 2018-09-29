package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the place_type_assign database table.
 * 
 */
@Entity
@Table(name="place_type_assign")
@NamedQuery(name="PlaceTypeAssign.findAll", query="SELECT p FROM PlaceTypeAssign p")
public class PlaceTypeAssign  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	//bi-directional many-to-one association to Place
	@ManyToOne
	private Place place;

	//bi-directional many-to-one association to PlaceType
	@ManyToOne
	@JoinColumn(name="place_type_id")
	private PlaceType placeType;

	public PlaceTypeAssign() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public PlaceType getPlaceType() {
		return this.placeType;
	}

	public void setPlaceType(PlaceType placeType) {
		this.placeType = placeType;
	}

}
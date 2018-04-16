package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the property database table.
 * 
 */
@Entity
@NamedQuery(name="Property.findAll", query="SELECT p FROM Property p")
public class Property  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	private String name;

	//bi-directional many-to-one association to PropertyImage
	@OneToMany(mappedBy="property")
	private List<PropertyImage> propertyImages;

	//bi-directional many-to-one association to PropertyValue
	@OneToMany(mappedBy="property")
	private List<PropertyValue> propertyValues;

	public Property() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public List<PropertyImage> getPropertyImages() {
		return this.propertyImages;
	}

	public void setPropertyImages(List<PropertyImage> propertyImages) {
		this.propertyImages = propertyImages;
	}

	public PropertyImage addPropertyImage(PropertyImage propertyImage) {
		getPropertyImages().add(propertyImage);
		propertyImage.setProperty(this);

		return propertyImage;
	}

	public PropertyImage removePropertyImage(PropertyImage propertyImage) {
		getPropertyImages().remove(propertyImage);
		propertyImage.setProperty(null);

		return propertyImage;
	}

	public List<PropertyValue> getPropertyValues() {
		return this.propertyValues;
	}

	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}

	public PropertyValue addPropertyValue(PropertyValue propertyValue) {
		getPropertyValues().add(propertyValue);
		propertyValue.setProperty(this);

		return propertyValue;
	}

	public PropertyValue removePropertyValue(PropertyValue propertyValue) {
		getPropertyValues().remove(propertyValue);
		propertyValue.setProperty(null);

		return propertyValue;
	}

}
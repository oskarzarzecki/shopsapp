package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the application_settings database table.
 * 
 */
@Entity
@Table(name="application_settings")
@NamedQuery(name="ApplicationSetting.findAll", query="SELECT a FROM ApplicationSetting a")
public class ApplicationSetting  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	@Lob
	private String value;

	//bi-directional many-to-one association to Module
	@ManyToOne
	private Module module;

	public ApplicationSetting() {
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
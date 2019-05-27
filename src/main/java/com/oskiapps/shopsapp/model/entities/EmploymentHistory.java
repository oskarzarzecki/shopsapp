package com.oskiapps.shopsapp.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employment_history database table.
 * 
 */
@Entity
@Table(name="employment_history")
@NamedQuery(name="EmploymentHistory.findAll", query="SELECT e FROM EmploymentHistory e")
public class EmploymentHistory  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to Department
	@ManyToOne
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	//bi-directional many-to-one association to Place
	@ManyToOne
	private Place place;

	public EmploymentHistory() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}
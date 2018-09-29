package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to EmploymentHistory
	@OneToMany(mappedBy="department")
	private List<EmploymentHistory> employmentHistories;

	public Department() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmploymentHistory> getEmploymentHistories() {
		return this.employmentHistories;
	}

	public void setEmploymentHistories(List<EmploymentHistory> employmentHistories) {
		this.employmentHistories = employmentHistories;
	}

	public EmploymentHistory addEmploymentHistory(EmploymentHistory employmentHistory) {
		getEmploymentHistories().add(employmentHistory);
		employmentHistory.setDepartment(this);

		return employmentHistory;
	}

	public EmploymentHistory removeEmploymentHistory(EmploymentHistory employmentHistory) {
		getEmploymentHistories().remove(employmentHistory);
		employmentHistory.setDepartment(null);

		return employmentHistory;
	}

}
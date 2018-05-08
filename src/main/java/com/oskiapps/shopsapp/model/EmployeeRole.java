package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee_role database table.
 * 
 */
@Entity
@Table(name="employee_role")
@NamedQuery(name="EmployeeRole.findAll", query="SELECT e FROM EmployeeRole e")
public class EmployeeRole  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	@Lob
	private String description;

	@Lob
	private String name;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne
	@JoinColumn(name="employee_account_id")
	private EmployeeAccount employeeAccount;

	//bi-directional many-to-one association to EmployeePlaceAccess
	@OneToMany(mappedBy="employeeRole")
	private List<EmployeePlaceAccess> employeePlaceAccesses;

	public EmployeeRole() {
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

	public EmployeeAccount getEmployeeAccount() {
		return this.employeeAccount;
	}

	public void setEmployeeAccount(EmployeeAccount employeeAccount) {
		this.employeeAccount = employeeAccount;
	}

	public List<EmployeePlaceAccess> getEmployeePlaceAccesses() {
		return this.employeePlaceAccesses;
	}

	public void setEmployeePlaceAccesses(List<EmployeePlaceAccess> employeePlaceAccesses) {
		this.employeePlaceAccesses = employeePlaceAccesses;
	}

	public EmployeePlaceAccess addEmployeePlaceAccess(EmployeePlaceAccess employeePlaceAccess) {
		getEmployeePlaceAccesses().add(employeePlaceAccess);
		employeePlaceAccess.setEmployeeRole(this);

		return employeePlaceAccess;
	}

	public EmployeePlaceAccess removeEmployeePlaceAccess(EmployeePlaceAccess employeePlaceAccess) {
		getEmployeePlaceAccesses().remove(employeePlaceAccess);
		employeePlaceAccess.setEmployeeRole(null);

		return employeePlaceAccess;
	}

}
package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee_module_access database table.
 * 
 */
@Entity
@Table(name="employee_module_access")
@NamedQuery(name="EmployeeModuleAccess.findAll", query="SELECT e FROM EmployeeModuleAccess e")
public class EmployeeModuleAccess  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private int active;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	@Temporal(TemporalType.DATE)
	@Column(name="date_from")
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="date_to")
	private Date dateTo;

	private int deleted;

	//bi-directional many-to-one association to EmployeeLogin
	@OneToMany(mappedBy="employeeModuleAccess")
	private List<EmployeeLogin> employeeLogins;

	//bi-directional many-to-one association to EmployeePlaceAccess
	@ManyToOne
	@JoinColumn(name="employee_place_access_id")
	private EmployeePlaceAccess employeePlaceAccess;

	//bi-directional many-to-one association to Module
	@ManyToOne
	private Module module;

	public EmployeeModuleAccess() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getDateDeleted() {
		return this.dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public List<EmployeeLogin> getEmployeeLogins() {
		return this.employeeLogins;
	}

	public void setEmployeeLogins(List<EmployeeLogin> employeeLogins) {
		this.employeeLogins = employeeLogins;
	}

	public EmployeeLogin addEmployeeLogin(EmployeeLogin employeeLogin) {
		getEmployeeLogins().add(employeeLogin);
		employeeLogin.setEmployeeModuleAccess(this);

		return employeeLogin;
	}

	public EmployeeLogin removeEmployeeLogin(EmployeeLogin employeeLogin) {
		getEmployeeLogins().remove(employeeLogin);
		employeeLogin.setEmployeeModuleAccess(null);

		return employeeLogin;
	}

	public EmployeePlaceAccess getEmployeePlaceAccess() {
		return this.employeePlaceAccess;
	}

	public void setEmployeePlaceAccess(EmployeePlaceAccess employeePlaceAccess) {
		this.employeePlaceAccess = employeePlaceAccess;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
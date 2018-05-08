package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the employee_login database table.
 * 
 */
@Entity
@Table(name="employee_login")
@NamedQuery(name="EmployeeLogin.findAll", query="SELECT e FROM EmployeeLogin e")
public class EmployeeLogin  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String browser;

	@Temporal(TemporalType.DATE)
	@Column(name="date_from")
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="date_to")
	private Date dateTo;

	private String ip;

	//bi-directional many-to-one association to EmployeeModuleAccess
	@ManyToOne
	@JoinColumn(name="employee_module_access_id")
	private EmployeeModuleAccess employeeModuleAccess;

	//bi-directional many-to-one association to EmployeePlaceAccess
	@ManyToOne
	@JoinColumn(name="employee_place_access_id")
	private EmployeePlaceAccess employeePlaceAccess;

	public EmployeeLogin() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrowser() {
		return this.browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
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

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public EmployeeModuleAccess getEmployeeModuleAccess() {
		return this.employeeModuleAccess;
	}

	public void setEmployeeModuleAccess(EmployeeModuleAccess employeeModuleAccess) {
		this.employeeModuleAccess = employeeModuleAccess;
	}

	public EmployeePlaceAccess getEmployeePlaceAccess() {
		return this.employeePlaceAccess;
	}

	public void setEmployeePlaceAccess(EmployeePlaceAccess employeePlaceAccess) {
		this.employeePlaceAccess = employeePlaceAccess;
	}

}
package com.oskiapps.shopsapp.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee_account database table.
 * 
 */
@Entity
@Table(name="employee_account")
@NamedQuery(name="EmployeeAccount.findAll", query="SELECT e FROM EmployeeAccount e")
public class EmployeeAccount  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Temporal(TemporalType.DATE)
	@Column(name="last_visit")
	private Date lastVisit;

	private String login;

	private int online;

	@Column(name="password_hash")
	private String passwordHash;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	//bi-directional many-to-one association to EmployeeAccountSetting
	@OneToMany(mappedBy="employeeAccount")
	private List<EmployeeAccountSetting> employeeAccountSettings;

	//bi-directional many-to-one association to EmployeeLogin
	@OneToMany(mappedBy="employeeAccount")
	private List<EmployeeLogin> employeeLogins;

	//bi-directional many-to-one association to EmployeePlaceAccess
	@OneToMany(mappedBy="employeeAccount")
	private List<EmployeePlaceAccess> employeePlaceAccesses;

	public EmployeeAccount() {
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

	public Date getLastVisit() {
		return this.lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getOnline() {
		return this.online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<EmployeeAccountSetting> getEmployeeAccountSettings() {
		return this.employeeAccountSettings;
	}

	public void setEmployeeAccountSettings(List<EmployeeAccountSetting> employeeAccountSettings) {
		this.employeeAccountSettings = employeeAccountSettings;
	}

	public EmployeeAccountSetting addEmployeeAccountSetting(EmployeeAccountSetting employeeAccountSetting) {
		getEmployeeAccountSettings().add(employeeAccountSetting);
		employeeAccountSetting.setEmployeeAccount(this);

		return employeeAccountSetting;
	}

	public EmployeeAccountSetting removeEmployeeAccountSetting(EmployeeAccountSetting employeeAccountSetting) {
		getEmployeeAccountSettings().remove(employeeAccountSetting);
		employeeAccountSetting.setEmployeeAccount(null);

		return employeeAccountSetting;
	}

	public List<EmployeeLogin> getEmployeeLogins() {
		return this.employeeLogins;
	}

	public void setEmployeeLogins(List<EmployeeLogin> employeeLogins) {
		this.employeeLogins = employeeLogins;
	}

	public EmployeeLogin addEmployeeLogin(EmployeeLogin employeeLogin) {
		getEmployeeLogins().add(employeeLogin);
		employeeLogin.setEmployeeAccount(this);

		return employeeLogin;
	}

	public EmployeeLogin removeEmployeeLogin(EmployeeLogin employeeLogin) {
		getEmployeeLogins().remove(employeeLogin);
		employeeLogin.setEmployeeAccount(null);

		return employeeLogin;
	}

	public List<EmployeePlaceAccess> getEmployeePlaceAccesses() {
		return this.employeePlaceAccesses;
	}

	public void setEmployeePlaceAccesses(List<EmployeePlaceAccess> employeePlaceAccesses) {
		this.employeePlaceAccesses = employeePlaceAccesses;
	}

	public EmployeePlaceAccess addEmployeePlaceAccess(EmployeePlaceAccess employeePlaceAccess) {
		getEmployeePlaceAccesses().add(employeePlaceAccess);
		employeePlaceAccess.setEmployeeAccount(this);

		return employeePlaceAccess;
	}

	public EmployeePlaceAccess removeEmployeePlaceAccess(EmployeePlaceAccess employeePlaceAccess) {
		getEmployeePlaceAccesses().remove(employeePlaceAccess);
		employeePlaceAccess.setEmployeeAccount(null);

		return employeePlaceAccess;
	}

}
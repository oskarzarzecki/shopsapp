package com.oskiapps.shopsapp.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the employee_place_access database table.
 * 
 */
@Entity
@Table(name="employee_place_access")
@NamedQuery(name="EmployeePlaceAccess.findAll", query="SELECT e FROM EmployeePlaceAccess e")
public class EmployeePlaceAccess  {
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

	@Column(name="employee_role_id")
	private BigInteger employeeRoleId;

	//bi-directional many-to-one association to EmployeeModuleAccess
	@OneToMany(mappedBy="employeePlaceAccess")
	private List<EmployeeModuleAccess> employeeModuleAccesses;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne
	@JoinColumn(name="employee_account_id")
	private EmployeeAccount employeeAccount;

	//bi-directional many-to-one association to Place
	@ManyToOne
	private Place place;

	public EmployeePlaceAccess() {
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

	public BigInteger getEmployeeRoleId() {
		return this.employeeRoleId;
	}

	public void setEmployeeRoleId(BigInteger employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	public List<EmployeeModuleAccess> getEmployeeModuleAccesses() {
		return this.employeeModuleAccesses;
	}

	public void setEmployeeModuleAccesses(List<EmployeeModuleAccess> employeeModuleAccesses) {
		this.employeeModuleAccesses = employeeModuleAccesses;
	}

	public EmployeeModuleAccess addEmployeeModuleAccess(EmployeeModuleAccess employeeModuleAccess) {
		getEmployeeModuleAccesses().add(employeeModuleAccess);
		employeeModuleAccess.setEmployeePlaceAccess(this);

		return employeeModuleAccess;
	}

	public EmployeeModuleAccess removeEmployeeModuleAccess(EmployeeModuleAccess employeeModuleAccess) {
		getEmployeeModuleAccesses().remove(employeeModuleAccess);
		employeeModuleAccess.setEmployeePlaceAccess(null);

		return employeeModuleAccess;
	}

	public EmployeeAccount getEmployeeAccount() {
		return this.employeeAccount;
	}

	public void setEmployeeAccount(EmployeeAccount employeeAccount) {
		this.employeeAccount = employeeAccount;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}
package com.oskiapps.shopsapp.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String city;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private int deleted;

	private String email;

	private int gender;

	private int hired;

	@Column(name="identification_number")
	private String identificationNumber;

	private String name;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="postal_code")
	private String postalCode;

	private String street;

	private String surname;

	//bi-directional many-to-one association to EmployeeAccount
	@OneToMany(mappedBy="employee")
	private List<EmployeeAccount> employeeAccounts;

	//bi-directional many-to-one association to EmployeeImage
	@OneToMany(mappedBy="employee")
	private List<EmployeeImage> employeeImages;

	//bi-directional many-to-one association to EmploymentHistory
	@OneToMany(mappedBy="employee")
	private List<EmploymentHistory> employmentHistories;

	//bi-directional many-to-one association to GroupEmployeeAssign
	@OneToMany(mappedBy="employee")
	private List<GroupEmployeeAssign> groupEmployeeAssigns;

	public Employee() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateDeleted() {
		return this.dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getHired() {
		return this.hired;
	}

	public void setHired(int hired) {
		this.hired = hired;
	}

	public String getIdentificationNumber() {
		return this.identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<EmployeeAccount> getEmployeeAccounts() {
		return this.employeeAccounts;
	}

	public void setEmployeeAccounts(List<EmployeeAccount> employeeAccounts) {
		this.employeeAccounts = employeeAccounts;
	}

	public EmployeeAccount addEmployeeAccount(EmployeeAccount employeeAccount) {
		getEmployeeAccounts().add(employeeAccount);
		employeeAccount.setEmployee(this);

		return employeeAccount;
	}

	public EmployeeAccount removeEmployeeAccount(EmployeeAccount employeeAccount) {
		getEmployeeAccounts().remove(employeeAccount);
		employeeAccount.setEmployee(null);

		return employeeAccount;
	}

	public List<EmployeeImage> getEmployeeImages() {
		return this.employeeImages;
	}

	public void setEmployeeImages(List<EmployeeImage> employeeImages) {
		this.employeeImages = employeeImages;
	}

	public EmployeeImage addEmployeeImage(EmployeeImage employeeImage) {
		getEmployeeImages().add(employeeImage);
		employeeImage.setEmployee(this);

		return employeeImage;
	}

	public EmployeeImage removeEmployeeImage(EmployeeImage employeeImage) {
		getEmployeeImages().remove(employeeImage);
		employeeImage.setEmployee(null);

		return employeeImage;
	}

	public List<EmploymentHistory> getEmploymentHistories() {
		return this.employmentHistories;
	}

	public void setEmploymentHistories(List<EmploymentHistory> employmentHistories) {
		this.employmentHistories = employmentHistories;
	}

	public EmploymentHistory addEmploymentHistory(EmploymentHistory employmentHistory) {
		getEmploymentHistories().add(employmentHistory);
		employmentHistory.setEmployee(this);

		return employmentHistory;
	}

	public EmploymentHistory removeEmploymentHistory(EmploymentHistory employmentHistory) {
		getEmploymentHistories().remove(employmentHistory);
		employmentHistory.setEmployee(null);

		return employmentHistory;
	}

	public List<GroupEmployeeAssign> getGroupEmployeeAssigns() {
		return this.groupEmployeeAssigns;
	}

	public void setGroupEmployeeAssigns(List<GroupEmployeeAssign> groupEmployeeAssigns) {
		this.groupEmployeeAssigns = groupEmployeeAssigns;
	}

	public GroupEmployeeAssign addGroupEmployeeAssign(GroupEmployeeAssign groupEmployeeAssign) {
		getGroupEmployeeAssigns().add(groupEmployeeAssign);
		groupEmployeeAssign.setEmployee(this);

		return groupEmployeeAssign;
	}

	public GroupEmployeeAssign removeGroupEmployeeAssign(GroupEmployeeAssign groupEmployeeAssign) {
		getGroupEmployeeAssigns().remove(groupEmployeeAssign);
		groupEmployeeAssign.setEmployee(null);

		return groupEmployeeAssign;
	}

}
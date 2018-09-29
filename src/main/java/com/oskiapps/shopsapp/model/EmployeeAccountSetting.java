package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employee_account_setting database table.
 * 
 */
@Entity
@Table(name="employee_account_setting")
@NamedQuery(name="EmployeeAccountSetting.findAll", query="SELECT e FROM EmployeeAccountSetting e")
public class EmployeeAccountSetting  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String value;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne
	@JoinColumn(name="employee_account_id")
	private EmployeeAccount employeeAccount;

	//bi-directional many-to-one association to EmployeeAccountSettingsList
	@ManyToOne
	@JoinColumn(name="employee_account_settings_list_id")
	private EmployeeAccountSettingsList employeeAccountSettingsList;

	public EmployeeAccountSetting() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public EmployeeAccount getEmployeeAccount() {
		return this.employeeAccount;
	}

	public void setEmployeeAccount(EmployeeAccount employeeAccount) {
		this.employeeAccount = employeeAccount;
	}

	public EmployeeAccountSettingsList getEmployeeAccountSettingsList() {
		return this.employeeAccountSettingsList;
	}

	public void setEmployeeAccountSettingsList(EmployeeAccountSettingsList employeeAccountSettingsList) {
		this.employeeAccountSettingsList = employeeAccountSettingsList;
	}

}
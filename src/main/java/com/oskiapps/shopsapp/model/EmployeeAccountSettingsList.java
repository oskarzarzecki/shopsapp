package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee_account_settings_list database table.
 * 
 */
@Entity
@Table(name="employee_account_settings_list")
@NamedQuery(name="EmployeeAccountSettingsList.findAll", query="SELECT e FROM EmployeeAccountSettingsList e")
public class EmployeeAccountSettingsList  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Lob
	private String name;

	//bi-directional many-to-one association to EmployeeAccountSetting
	@OneToMany(mappedBy="employeeAccountSettingsList")
	private List<EmployeeAccountSetting> employeeAccountSettings;

	public EmployeeAccountSettingsList() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeAccountSetting> getEmployeeAccountSettings() {
		return this.employeeAccountSettings;
	}

	public void setEmployeeAccountSettings(List<EmployeeAccountSetting> employeeAccountSettings) {
		this.employeeAccountSettings = employeeAccountSettings;
	}

	public EmployeeAccountSetting addEmployeeAccountSetting(EmployeeAccountSetting employeeAccountSetting) {
		getEmployeeAccountSettings().add(employeeAccountSetting);
		employeeAccountSetting.setEmployeeAccountSettingsList(this);

		return employeeAccountSetting;
	}

	public EmployeeAccountSetting removeEmployeeAccountSetting(EmployeeAccountSetting employeeAccountSetting) {
		getEmployeeAccountSettings().remove(employeeAccountSetting);
		employeeAccountSetting.setEmployeeAccountSettingsList(null);

		return employeeAccountSetting;
	}

}
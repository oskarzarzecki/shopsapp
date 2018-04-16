package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int active;

	@Lob
	private String description;

	@Lob
	private String name;

	//bi-directional many-to-one association to ApplicationSetting
	@OneToMany(mappedBy="module")
	private List<ApplicationSetting> applicationSettings;

	//bi-directional many-to-one association to EmployeeModuleAcce
	@OneToMany(mappedBy="module")
	private List<EmployeeModuleAccess> employeeModuleAcces;

	public Module() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
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

	public List<ApplicationSetting> getApplicationSettings() {
		return this.applicationSettings;
	}

	public void setApplicationSettings(List<ApplicationSetting> applicationSettings) {
		this.applicationSettings = applicationSettings;
	}

	public ApplicationSetting addApplicationSetting(ApplicationSetting applicationSetting) {
		getApplicationSettings().add(applicationSetting);
		applicationSetting.setModule(this);

		return applicationSetting;
	}

	public ApplicationSetting removeApplicationSetting(ApplicationSetting applicationSetting) {
		getApplicationSettings().remove(applicationSetting);
		applicationSetting.setModule(null);

		return applicationSetting;
	}

	public List<EmployeeModuleAccess> getEmployeeModuleAcces() {
		return this.employeeModuleAcces;
	}

	public void setEmployeeModuleAcces(List<EmployeeModuleAccess> employeeModuleAcces) {
		this.employeeModuleAcces = employeeModuleAcces;
	}

	public EmployeeModuleAccess addEmployeeModuleAcce(EmployeeModuleAccess employeeModuleAcce) {
		getEmployeeModuleAcces().add(employeeModuleAcce);
		employeeModuleAcce.setModule(this);

		return employeeModuleAcce;
	}

	public EmployeeModuleAccess removeEmployeeModuleAcce(EmployeeModuleAccess employeeModuleAcce) {
		getEmployeeModuleAcces().remove(employeeModuleAcce);
		employeeModuleAcce.setModule(null);

		return employeeModuleAcce;
	}

}
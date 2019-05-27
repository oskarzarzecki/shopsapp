package com.oskiapps.shopsapp.model.entities;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int active;

	@Lob
	private String description;

	@Lob
	private String name;

	//bi-directional many-to-one association to ApplicationSetting
	@OneToMany(mappedBy="module")
	private List<ApplicationSetting> applicationSettings;

	//bi-directional many-to-one association to EmployeeModuleAccess
	@OneToMany(mappedBy="module")
	private List<EmployeeModuleAccess> employeeModuleAccesses;

	public Module() {
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

	public List<EmployeeModuleAccess> getEmployeeModuleAccesses() {
		return this.employeeModuleAccesses;
	}

	public void setEmployeeModuleAccesses(List<EmployeeModuleAccess> employeeModuleAccesses) {
		this.employeeModuleAccesses = employeeModuleAccesses;
	}

	public EmployeeModuleAccess addEmployeeModuleAccess(EmployeeModuleAccess employeeModuleAccess) {
		getEmployeeModuleAccesses().add(employeeModuleAccess);
		employeeModuleAccess.setModule(this);

		return employeeModuleAccess;
	}

	public EmployeeModuleAccess removeEmployeeModuleAccess(EmployeeModuleAccess employeeModuleAccess) {
		getEmployeeModuleAccesses().remove(employeeModuleAccess);
		employeeModuleAccess.setModule(null);

		return employeeModuleAccess;
	}

}
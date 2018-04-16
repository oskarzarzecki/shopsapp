package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the group_employee_assign database table.
 * 
 */
@Entity
@Table(name="group_employee_assign")
@NamedQuery(name="GroupEmployeeAssign.findAll", query="SELECT g FROM GroupEmployeeAssign g")
public class GroupEmployeeAssign  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	//bi-directional many-to-one association to EmployeeGroup
	@ManyToOne
	@JoinColumn(name="employee_group_id")
	private EmployeeGroup employeeGroup;

	public GroupEmployeeAssign() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeGroup getEmployeeGroup() {
		return this.employeeGroup;
	}

	public void setEmployeeGroup(EmployeeGroup employeeGroup) {
		this.employeeGroup = employeeGroup;
	}

}
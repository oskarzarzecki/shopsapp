package com.oskiapps.shopsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee_group database table.
 * 
 */
@Entity
@Table(name="employee_group")
@NamedQuery(name="EmployeeGroup.findAll", query="SELECT e FROM EmployeeGroup e")
public class EmployeeGroup  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deleted")
	private Date dateDeleted;

	private int deleted;

	@Lob
	private String description;

	private String name;

	@Column(name="users_limit")
	private int usersLimit;

	@Column(name="users_number")
	private int usersNumber;

	//bi-directional many-to-one association to GroupEmployeeAssign
	@OneToMany(mappedBy="employeeGroup")
	private List<GroupEmployeeAssign> groupEmployeeAssigns;

	public EmployeeGroup() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAvailable() {
		return this.available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Date getDateDeleted() {
		return this.dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
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

	public int getUsersLimit() {
		return this.usersLimit;
	}

	public void setUsersLimit(int usersLimit) {
		this.usersLimit = usersLimit;
	}

	public int getUsersNumber() {
		return this.usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public List<GroupEmployeeAssign> getGroupEmployeeAssigns() {
		return this.groupEmployeeAssigns;
	}

	public void setGroupEmployeeAssigns(List<GroupEmployeeAssign> groupEmployeeAssigns) {
		this.groupEmployeeAssigns = groupEmployeeAssigns;
	}

	public GroupEmployeeAssign addGroupEmployeeAssign(GroupEmployeeAssign groupEmployeeAssign) {
		getGroupEmployeeAssigns().add(groupEmployeeAssign);
		groupEmployeeAssign.setEmployeeGroup(this);

		return groupEmployeeAssign;
	}

	public GroupEmployeeAssign removeGroupEmployeeAssign(GroupEmployeeAssign groupEmployeeAssign) {
		getGroupEmployeeAssigns().remove(groupEmployeeAssign);
		groupEmployeeAssign.setEmployeeGroup(null);

		return groupEmployeeAssign;
	}

}
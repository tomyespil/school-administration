package com.teracode.school.administration.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "janitor")
public class Janitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_janitor;
	
	@Column(nullable = false, name = "working_area")
	private String workingArea;

	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(nullable = false, name = "person_id")
	private int personId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id_person", insertable = false, updatable = false)
    private Person person;

	public int getId_janitor() {
		return id_janitor;
	}

	public void setId_janitor(int id_janitor) {
		this.id_janitor = id_janitor;
	}

	public String getWorkingArea() {
		return workingArea;
	}

	public void setWorkingArea(String workingArea) {
		this.workingArea = workingArea;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}

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
@Table(name = "principal")
public class Principal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_principal;
	
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(nullable = false, name = "person_id")
	private int personId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id_person", insertable = false, updatable = false)
    private Person person;

	public int getId_principal() {
		return id_principal;
	}

	public void setId_principal(int id_principal) {
		this.id_principal = id_principal;
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

package com.teracode.school.administration.api.dto;

import java.sql.Date;

import com.teracode.school.administration.utils.enums.Gender;

public class PersonOut {
	public int id;
	public String name;
	public String lastName;
	public String address;
	public Long phone;
	public Date birthDate;
	public Gender gender;
	public String emailAddress;
}

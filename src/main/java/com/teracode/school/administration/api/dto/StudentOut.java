package com.teracode.school.administration.api.dto;

import java.sql.Date;

public class StudentOut extends PersonOut {
	public String personId;
	public Date enrollDate;
	public boolean graduated;
	public Date graduationDate;
	public Long createdAt;
	public Long updatedAt;
}

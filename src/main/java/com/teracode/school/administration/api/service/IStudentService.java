package com.teracode.school.administration.api.service;

import com.teracode.school.administration.api.model.Student;

public interface IStudentService {
	
	Student getStudent(Integer id);
	 
    void createStudent(Student student);

}

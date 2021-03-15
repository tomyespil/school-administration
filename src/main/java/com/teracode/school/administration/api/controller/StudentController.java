package com.teracode.school.administration.api.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teracode.school.administration.api.ApiRest;
import com.teracode.school.administration.api.model.Student;
import com.teracode.school.administration.api.service.StudentService;

@RestController
public class StudentController extends ApiRest {
	
	public static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentSrv;
	
	@GetMapping(path="/student/by_initial")
	public @ResponseBody ResponseEntity<HashMap<String, List<Student>>> getStudentsGrouped() {
		try {
			return new ResponseEntity<HashMap<String, List<Student>>>(studentSrv.getStudentsGrouped(), HttpStatus.OK);
		} catch(Exception e) {
			logger.error("Internal server error", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/student/between_age/19/21")
	public @ResponseBody ResponseEntity<List<Student>> getStudentsBetween19and21() {
		try {
			return new ResponseEntity<List<Student>>(studentSrv.getStudentsBetween19and21(), HttpStatus.OK);
		} catch(Exception e) {
			logger.error("Internal server error", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

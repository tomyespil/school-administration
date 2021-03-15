package com.teracode.school.administration.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teracode.school.administration.api.exception.SubjectNotFound;
import com.teracode.school.administration.api.model.Student;
import com.teracode.school.administration.api.model.Subject;
import com.teracode.school.administration.api.repository.StudentRepository;
import com.teracode.school.administration.api.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudentsBySubject(String subjectName) throws SubjectNotFound {
		Subject subject = subjectRepository.findByName(subjectName);
		if (subject != null) {
			List<Student> students = studentRepository.findStudentsBySubject(subjectName);
			List<Student> studentsDistinct = students.stream().distinct().collect(Collectors.toList());
			return studentsDistinct;
		} else {
			throw new SubjectNotFound();
		}
	}

}

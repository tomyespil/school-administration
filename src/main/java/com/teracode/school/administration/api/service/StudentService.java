package com.teracode.school.administration.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teracode.school.administration.api.model.Student;
import com.teracode.school.administration.api.repository.StudentRepository;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(Integer id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}

	@Override
	public void createStudent(Student student) {
		studentRepository.save(student);
	}

	public HashMap<String, List<Student>> getStudentsGrouped() {
		List<Student> students = studentRepository.groupStudentsByLastNameInitial();
		HashMap<String, List<Student>> list = new HashMap<String, List<Student>>();
		if (!students.isEmpty()) {
			for (Student student : students) {
				String initial = String.valueOf(student.getPerson().getLastName().charAt(0));
				if (!list.containsKey(initial)) {
					list.put(initial, new ArrayList<Student>());
				}
				list.get(initial).add(student);
			}
		}
		return list;
	}

	public List<Student> getStudentsBetween19and21() {
		List<Student> students = studentRepository.findStudentsBetween19and21();
		return students;
	}

}

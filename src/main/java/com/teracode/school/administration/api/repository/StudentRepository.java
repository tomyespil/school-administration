package com.teracode.school.administration.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teracode.school.administration.api.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value="SELECT *, (SUBSTR(last_name,1,1)) AS INITIAL FROM person p INNER JOIN student s ON p.id_person = s.id_student GROUP BY p.last_name", nativeQuery = true)
	List<Student> groupStudentsByLastNameInitial();
	
	@Query(value="SELECT * FROM person p INNER JOIN student s ON s.person_id = p.id_person WHERE FLOOR(datediff(now(), p.birthdate) / 365.25) BETWEEN 19 AND 21", nativeQuery=true)
	List<Student> findStudentsBetween19and21();
	
	@Query(value="SELECT * FROM person p INNER JOIN student s ON p.id_person = s.person_id LEFT JOIN subjects_enrollments se ON se.student_id = s.id_student LEFT JOIN subject su ON su.id_subject = se.subject_id WHERE su.name_subject = ?1", nativeQuery=true)
	List<Student> findStudentsBySubject(String subject);

}

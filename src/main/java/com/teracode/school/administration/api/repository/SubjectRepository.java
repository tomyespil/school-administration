package com.teracode.school.administration.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teracode.school.administration.api.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
	@Query(value="SELECT * FROM subject WHERE name_subject = ?1", nativeQuery=true) 
	Subject findByName(String subjectName);

}

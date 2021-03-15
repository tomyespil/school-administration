package com.teracode.school.administration.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teracode.school.administration.api.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}

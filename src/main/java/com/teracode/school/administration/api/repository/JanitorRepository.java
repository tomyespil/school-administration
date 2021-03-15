package com.teracode.school.administration.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teracode.school.administration.api.model.Janitor;

@Repository
public interface JanitorRepository extends JpaRepository<Janitor, Integer> {

}

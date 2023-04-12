package com.example.springbootwithpostgres.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springbootwithpostgres.model.Person;

@RepositoryRestResource
public interface PersonDao extends JpaRepository<Person, Long>{

}

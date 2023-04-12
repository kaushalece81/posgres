package com.example.springbootwithpostgres.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootwithpostgres.dao.PersonDao;
import com.example.springbootwithpostgres.model.Person;



@RestController
public class PersonController {
	@Autowired
	private PersonDao personDao;

	@PostMapping("/persons")
	public void addPerson(@RequestBody Person person) {
		personDao.save(person);
	}
	
	@GetMapping("/persons/{id}")
	public Person getPersonById(@PathVariable Long id) {
		Optional<Person> optionalPerson=personDao.findById(id);
		return (optionalPerson.isPresent())?optionalPerson.get():null;
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPerson() {
		return personDao.findAll();
	}
}

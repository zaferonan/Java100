package com.turkcell.challenge9.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.challenge9.model.Person;
import com.turkcell.challenge9.repository.PersonRepository;

@RestController
@RequestMapping(path = "person")
public class PersonController {

	@Autowired
	public PersonRepository personRepository;

	/**
	 * Api URL : http://localhost:8080/challenge9SpringJDBCwPostGre/person/getAll
	 * 
	 * @return person list as JSON format
	 */
	@GetMapping(path = "getAll")
	public ArrayList<Person> getAll() {
		return personRepository.getAll();
	}

	/**
	 * Api URL :
	 * http://localhost:8080/challenge9SpringJDBCwPostGre/person/getById?personId={personId}
	 * 
	 * @param personId
	 * @return Requested person by Id as JSON format
	 */
	@GetMapping(path = "getById")
	public ResponseEntity<Object> getById(@RequestParam int personId) {
		if (personRepository.getById(personId) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(personRepository.getById(personId));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not found in the database!!!");
		}
	}

	/**
	 * Api URL : http://localhost:8080/challenge9SpringJDBCwPostGre/person/save ***
	 * Expects RequestBody Person asJSON format without id{ "personName":"Numan"}
	 * 
	 * @param person
	 * @return Saves person in the database
	 */
	@PostMapping(path = "save")
	public ResponseEntity<String> save(@RequestBody Person person) {
		if (personRepository.save(person)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(person.getPersonName() + " saved to person database");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Person could not be saved in the database ");
		}
	}

	/**
	 * Api URL : http://localhost:8080/challenge9SpringJDBCwPostGre/person/update
	 * *** Expects person as JSON format with Id and update this Id in the database
	 * Example JSON { "personId":4, "personName":"Zafer"}
	 * 
	 * @param person
	 * @return Updates person in the database if id exists in the database
	 */
	@PostMapping(path = "update")
	public ResponseEntity<String> update(@RequestBody Person person) {
		if (personRepository.update(person)) {
			return ResponseEntity.status(HttpStatus.OK).body("Person is updated in the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Person could not be updated in the database ");
		}

	}

	/**
	 * Api URL : http://localhost:8080/challenge9SpringJDBCwPostGre/person/delete?id={id}
	 * @param id
	 * @return Deletes the person in the database
	 */
	@DeleteMapping(path = "delete")
	public ResponseEntity<String> deleteById(@RequestParam int id) {
		if (personRepository.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Person is deleted in the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Person could not be deleted in the database ");
		}
	}

}

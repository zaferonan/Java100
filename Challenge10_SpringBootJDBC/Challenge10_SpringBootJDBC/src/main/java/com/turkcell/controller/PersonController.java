package com.turkcell.controller;

import java.util.List;

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

import com.turkcell.model.Person;
import com.turkcell.service.abstracts.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Person>> getAll() {
		
		return ResponseEntity.status(HttpStatus.OK).body(personService.getAll());
	}

	@GetMapping("/getById")
	public ResponseEntity<Person> getById(@RequestParam int personId) {
		return ResponseEntity.status(HttpStatus.FOUND).body(personService.getById(personId));
	}
	
	@GetMapping("/getByName")
	public ResponseEntity<Person> getByName(@RequestParam String personName){
		return ResponseEntity.status(HttpStatus.FOUND).body(personService.getByName(personName));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int personId){
		if(personService.delete(personId)) {
			return ResponseEntity.ok("Person is deleted from database.");
		}
		return ResponseEntity.internalServerError().body("There is no person with this Id in the database!");
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Person person){
		if(personService.add(person)) {
			return ResponseEntity.ok("Person is added to database.");
		}
		return ResponseEntity.internalServerError().body("Person name is exists in the database!");
	}
	@PostMapping("/update")
	public ResponseEntity<String> update(@RequestBody Person person){
		if(personService.update(person)) {
			return ResponseEntity.ok("Person is updated at the database.");
		}
		return ResponseEntity.internalServerError().body("There is no person with this Id or person name is exists in the database!");
	}
}

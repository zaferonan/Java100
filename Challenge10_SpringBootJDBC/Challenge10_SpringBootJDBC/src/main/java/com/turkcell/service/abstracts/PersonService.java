package com.turkcell.service.abstracts;

import java.util.List;

import com.turkcell.model.Person;

public interface PersonService {

	public List<Person> getAll();
	public Person getById(int personId);
	public Person getByName(String personName);
	public boolean add(Person person);
	public boolean update(Person person);
	public boolean delete(int personId);
	
}

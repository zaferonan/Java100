package com.turkcell.repository.abstracts;

import java.util.ArrayList;

import com.turkcell.model.Person;

public interface IPersonRepository {

	public boolean save(Person person) ;
	public boolean update(Person person);
	public boolean delete(int personId);
	public ArrayList<Person> getAll();
	public Person getById(int personId);
	public Person getByName(String personName);
}

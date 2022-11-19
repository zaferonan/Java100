package com.turkcell.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.model.Person;
import com.turkcell.repository.abstracts.IPersonRepository;
import com.turkcell.service.abstracts.PersonService;

@Service
public class PersonManager implements PersonService {

	@Autowired
	IPersonRepository iPersonRepository;

	@Override
	public List<Person> getAll() {

		return iPersonRepository.getAll();
	}

	@Override
	public Person getById(int personId) {
		Person tempPerson = iPersonRepository.getById(personId);
		if (tempPerson != null) {
			return tempPerson;
		} else {
			return null;
		}

	}

	@Override
	public boolean add(Person person) {
		if (!isExistByName(person.getPersonName())&&iPersonRepository.save(person)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Person person) {
		if (isExistById(person.getPersonId())&&!isExistByName(person.getPersonName())) {
			iPersonRepository.update(person);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int personId) {
		if (isExistById(personId)) {
			iPersonRepository.delete(personId);
			return true;
		}
		return false;
	}

	@Override
	public Person getByName(String personName) {

		Person tempPerson = iPersonRepository.getByName(personName);
		if (tempPerson != null) {
			return tempPerson;
		} else {
			return null;
		}
	}

	private boolean isExistById(int personId) {

		return iPersonRepository.getById(personId) != null;
	}

	private boolean isExistByName(String personName) {

		return iPersonRepository.getByName(personName) != null;
	}

}

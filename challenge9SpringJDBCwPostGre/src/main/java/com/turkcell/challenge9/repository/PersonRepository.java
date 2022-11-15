package com.turkcell.challenge9.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.challenge9.model.Person;

@Repository
public class PersonRepository {

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public boolean save(Person person) {

		String sql = "insert into Person (name) values (:name)";		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", person.getPersonName());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	public boolean update(Person person) {
		String sql = "update person set name = :name where id = :id";		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", person.getPersonId());
		paramMap.put("name", person.getPersonName());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;

	}

	public boolean delete(int personId) {
		String sql = "delete from person where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", personId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	public ArrayList<Person> getAll() {
		String sql = "select * from person";
		ArrayList<Person> list = (ArrayList<Person>) namedParameterJdbcTemplate.query(sql, new PersonRowMapper());
		return list;
	}

	public Person getById(int personId) {
		String sql = "select * from person where id=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", personId);
		try {
			Person person= (Person) namedParameterJdbcTemplate.queryForObject(sql, paramMap, new PersonRowMapper());
			return person;
		} catch (Exception e) {
			return null;
		}
		
	}
}

package com.turkcell.challenge9.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.challenge9.model.Person;

public class PersonRowMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person=new Person();
		person.setPersonId(rs.getInt("id"));
		person.setPersonName(rs.getString("name"));
		return person;
	}

}

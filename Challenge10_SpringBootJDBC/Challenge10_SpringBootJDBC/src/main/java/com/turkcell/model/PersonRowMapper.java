package com.turkcell.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person=new Person();
		person.setPersonId(rs.getInt("id"));
		person.setPersonName(rs.getString("name"));
		return person;
	}

}

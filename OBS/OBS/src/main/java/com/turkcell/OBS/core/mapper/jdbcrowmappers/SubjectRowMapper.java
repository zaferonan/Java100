package com.turkcell.OBS.core.mapper.jdbcrowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.OBS.model.Subject;

public class SubjectRowMapper implements RowMapper<Subject> {

	@Override
	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Subject(rs.getLong("id"),rs.getString("name"));
	}

}

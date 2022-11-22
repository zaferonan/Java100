package com.turkcell.OBS.core.mapper.jdbcrowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.OBS.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getLong("id"));
		student.setStudentName(rs.getString("name"));
		student.setStudentNumber(rs.getLong("ogrnumber"));
		student.setStudentYear(rs.getInt("year"));
		return student;
	}

}

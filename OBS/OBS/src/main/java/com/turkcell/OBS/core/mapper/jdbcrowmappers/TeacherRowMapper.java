package com.turkcell.OBS.core.mapper.jdbcrowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.OBS.model.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teacher teacher=new Teacher();
		teacher.setTeacherId(rs.getLong("id"));
		teacher.setGicik(rs.getBoolean("isgicik"));
		teacher.setTeacherName(rs.getString("name"));
		
		return teacher;
	}

}

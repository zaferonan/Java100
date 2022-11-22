package com.turkcell.OBS.core.mapper.jdbcrowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.OBS.model.CourseStudent;

public class CourseStudentRowMapper implements RowMapper<CourseStudent> {

	@Override
	public CourseStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseStudent courseStudent = new CourseStudent();
		courseStudent.setCourseStudentId(rs.getLong("id"));
		courseStudent.setCourseStudentAbsence(rs.getInt("devamsizlik"));
		courseStudent.setCourseStudentNote(rs.getLong("note"));
		courseStudent.setCourseStudentCourseId(rs.getLong("ders_id"));
		courseStudent.setCourseStudentStudentId(rs.getLong("ogrenci_id"));
		return courseStudent;
	}

}

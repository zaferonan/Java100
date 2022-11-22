package com.turkcell.OBS.core.mapper.jdbcrowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.turkcell.OBS.model.Course;

public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getLong("id"));
		course.setCourseTeacherId(rs.getLong("ogretmen_id"));
		course.setCourseSubjectId(rs.getLong("konu_id"));
		return course;
	}

}

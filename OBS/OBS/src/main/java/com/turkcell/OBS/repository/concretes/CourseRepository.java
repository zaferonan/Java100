package com.turkcell.OBS.repository.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.OBS.core.mapper.jdbcrowmappers.CourseRowMapper;
import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.repository.abstracts.ICourseRepository;

@Repository
public class CourseRepository implements ICourseRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Course> getAll() {
		String sql = "select * from obsh.ders";
		List<Course> list = namedParameterJdbcTemplate.query(sql, new CourseRowMapper());
		return list;
	}

	@Override
	public boolean add(Course course) {
		String sql = "insert into obsh.ders (konu_id,ogretmen_id) values (:konu_id,:ogretmen_id)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("konu_id", course.getCourseSubjectId());
		paramMap.put("ogretmen_id", course.getCourseTeacherId());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public boolean update(Course course) {
		String sql = "update obsh.ders set (konu_id,ogretmen_id) = (:konu_id,:ogretmen_id) where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", course.getCourseId());
		paramMap.put("konu_id", course.getCourseSubjectId());
		paramMap.put("ogretmen_id", course.getCourseTeacherId());
		
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
		
	}

	@Override
	public boolean delete(long courseId) {
		String sql = "delete from obsh.ders where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", courseId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public Course getById(long courseId) {
		String sql = "select * from obsh.ders where (id)=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", courseId);
		try {
			Course course = (Course) namedParameterJdbcTemplate.queryForObject(sql, paramMap, new CourseRowMapper());
			return course;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Course> getByTeacher(long teacherId) {
		String sql = "select * from obsh.ders where (ogretmen_id)=:ogretmen_id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ogretmen_id", teacherId);
		List<Course> list = namedParameterJdbcTemplate.query(sql,paramMap, new CourseRowMapper());
		return list;
	}

	@Override
	public List<Course> getBySubject(long subjectId) {
		String sql = "select * from obsh.ders where (konu_id)=:konu_id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("konu_id", subjectId);
		List<Course> list = namedParameterJdbcTemplate.query(sql,paramMap, new CourseRowMapper());
		return list;
	}
	
	@Override
	public boolean isExists(Course course) {
		String sql = "select * from obsh.ders where (konu_id,ogretmen_id)=(:konu_id,:ogretmen_id)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("konu_id", course.getCourseSubjectId());
		paramMap.put("ogretmen_id", course.getCourseTeacherId());
		
		if(!namedParameterJdbcTemplate.query(sql, paramMap,new CourseRowMapper()).isEmpty()) {			
			return true;
		}else {
			return false;
		}
	}

}

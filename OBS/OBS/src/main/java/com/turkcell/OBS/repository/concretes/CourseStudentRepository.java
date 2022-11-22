package com.turkcell.OBS.repository.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.OBS.core.mapper.jdbcrowmappers.CourseStudentRowMapper;
import com.turkcell.OBS.model.CourseStudent;
import com.turkcell.OBS.repository.abstracts.ICourseStudentRepository;

@Repository
public class CourseStudentRepository implements ICourseStudentRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<CourseStudent> getAll() {
		String sql = "select * from obsh.ders_ogrenci";
		ArrayList<CourseStudent> list = (ArrayList<CourseStudent>) namedParameterJdbcTemplate.query(sql, new CourseStudentRowMapper());
		return list;
		
	}

	@Override
	public boolean add(CourseStudent courseStudent) {
		String sql = "insert into obsh.ders_ogrenci (devamsizlik,note,ders_id,ogrenci_id) values (:devamsizlik,:note,:ders_id,:ogrenci_id)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("devamsizlik", courseStudent.getCourseStudentAbsence());
		paramMap.put("note", courseStudent.getCourseStudentNote());
		paramMap.put("ders_id", courseStudent.getCourseStudentCourseId());
		paramMap.put("ogrenci_id", courseStudent.getCourseStudentStudentId());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public boolean update(CourseStudent courseStudent) {
		String sql = "update obsh.ders_ogrenci set (devamsizlik,note,ders_id,ogrenci_id) = (:devamsizlik,:note,:ders_id,:ogrenci_id) where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", courseStudent.getCourseStudentId());
		paramMap.put("devamsizlik", courseStudent.getCourseStudentAbsence());
		paramMap.put("note", courseStudent.getCourseStudentNote());
		paramMap.put("ders_id", courseStudent.getCourseStudentCourseId());
		paramMap.put("ogrenci_id", courseStudent.getCourseStudentStudentId());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
		
	}

	@Override
	public boolean delete(long courseStudentId) {
		String sql = "delete from obsh.ders_ogrenci where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", courseStudentId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public CourseStudent getById(long courseStudentId) {
		String sql = "select * from obsh.ders_ogrenci where (id)=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", courseStudentId);
		try {
			CourseStudent courseStudent = (CourseStudent) namedParameterJdbcTemplate.queryForObject(sql, paramMap, new CourseStudentRowMapper());
			return courseStudent;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean isExists(CourseStudent courseStudent) {
		String sql = "select * from obsh.ders_ogrenci where (ders_id,ogrenci_id)=(:ders_id,:ogrenci_id)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ders_id", courseStudent.getCourseStudentCourseId());
		paramMap.put("ogrenci_id", courseStudent.getCourseStudentStudentId());
		
		if(!namedParameterJdbcTemplate.query(sql, paramMap,new CourseStudentRowMapper()).isEmpty()) {			
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<CourseStudent> getByCourse(long courseId) {
		String sql = "select * from obsh.ders_ogrenci where (ders_id)=:ders_id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ders_id", courseId);
		ArrayList<CourseStudent> list = (ArrayList<CourseStudent>) namedParameterJdbcTemplate.query(sql,paramMap, new CourseStudentRowMapper());
		return list;
	}

	@Override
	public List<CourseStudent> getByStudent(long studentId) {
		String sql = "select * from obsh.ders_ogrenci where (ogrenci_id)=:ogrenci_id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ogrenci_id", studentId);
		ArrayList<CourseStudent> list = (ArrayList<CourseStudent>) namedParameterJdbcTemplate.query(sql,paramMap, new CourseStudentRowMapper());
		return list;
	}



}

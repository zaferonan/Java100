package com.turkcell.OBS.repository.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.OBS.core.mapper.jdbcrowmappers.TeacherRowMapper;
import com.turkcell.OBS.model.Teacher;
import com.turkcell.OBS.repository.abstracts.ITeacherRepository;

@Repository
public class TeacherRepository implements ITeacherRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Teacher> getAll() {
		String sql = "select * from obsh.ogretmen";
		ArrayList<Teacher> list = (ArrayList<Teacher>) namedParameterJdbcTemplate.query(sql, new TeacherRowMapper());
		
		return list;
		
	}

	@Override
	public boolean add(Teacher teacher) {
		String sql = "insert into obsh.ogretmen (name,isgicik) values (:name,:isgicik)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", teacher.getTeacherName());
		paramMap.put("isgicik", teacher.isGicik());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public boolean update(Teacher teacher) {
		String sql = "update obsh.ogretmen set (name,isgicik) = (:name,:isgicik) where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", teacher.getTeacherId());
		paramMap.put("name", teacher.getTeacherName());
		paramMap.put("isgicik", teacher.isGicik());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
		
	}

	@Override
	public boolean delete(long teacherId) {
		String sql = "delete from obsh.ogretmen where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", teacherId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public Teacher getById(long teacherId) {
		String sql = "select * from obsh.ogretmen where (id)=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", teacherId);
		try {
			Teacher teacher = (Teacher) namedParameterJdbcTemplate.queryForObject(sql, paramMap, new TeacherRowMapper());
			return teacher;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Teacher getByName(String teacherName) {
		String sql = "select * from obsh.ogretmen where upper(name) like upper(:name)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", teacherName);
		try {
			Teacher teacher = (Teacher) namedParameterJdbcTemplate.queryForObject(sql, paramMap, new TeacherRowMapper());
			return teacher;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

}

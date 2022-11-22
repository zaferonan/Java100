package com.turkcell.OBS.repository.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.OBS.core.mapper.jdbcrowmappers.SubjectRowMapper;
import com.turkcell.OBS.model.Subject;
import com.turkcell.OBS.repository.abstracts.ISubjectRepository;

@Repository
public class SubjectRepository implements ISubjectRepository{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Subject> getAll() {
		String sql = "select * from obsh.konu";
		ArrayList<Subject> list = (ArrayList<Subject>) namedParameterJdbcTemplate.query(sql, new SubjectRowMapper());
		return list;
	}

	@Override
	public boolean add(Subject subject) {
		String sql = "insert into obsh.konu (name) values (:name)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", subject.getSubjectName());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public boolean update(Subject subject) {
		String sql = "update obsh.konu set name = :name where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", subject.getSubjectId());
		paramMap.put("name", subject.getSubjectName());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public boolean delete(long subjectId) {
		String sql = "delete from obsh.konu where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", subjectId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public Subject getById(long subjectId) {
		String sql = "select * from obsh.konu where (id)=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", subjectId);
		try {
			Subject subject = (Subject) namedParameterJdbcTemplate.queryForObject(sql, paramMap, new SubjectRowMapper());
			return subject;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Subject getByName(String subjectName) {
		String sql = "select * from obsh.konu where upper(name) like upper(:name)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", subjectName);
		try {
			Subject subject = (Subject) namedParameterJdbcTemplate.queryForObject(sql, paramMap, new SubjectRowMapper());
			return subject;
		} catch (Exception e) {
			return null;
		}
	}


}

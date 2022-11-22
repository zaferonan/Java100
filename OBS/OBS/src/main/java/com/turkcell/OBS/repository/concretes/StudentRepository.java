package com.turkcell.OBS.repository.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.OBS.core.exceptions.BusinessException;
import com.turkcell.OBS.core.mapper.jdbcrowmappers.StudentRowMapper;
import com.turkcell.OBS.model.Student;
import com.turkcell.OBS.repository.abstracts.IStudentRepository;

@Repository
public class StudentRepository implements IStudentRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Student> getAll() {
		String sql = "select * from obsh.ogrenci";
		ArrayList<Student> list = (ArrayList<Student>) namedParameterJdbcTemplate.query(sql, new StudentRowMapper());
		return list;
	}

	@Override
	public boolean add(Student student) {
		String sql = "insert into obsh.ogrenci (name,ogrnumber,year) values (:name,:ogrnumber,:year)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", student.getStudentName());
		paramMap.put("ogrnumber", student.getStudentNumber());
		paramMap.put("year", student.getStudentYear());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public boolean update(Student student) {
		String sql = "update obsh.ogrenci set (name,ogrnumber,year) = (:name,:ogrnumber,:year) where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", student.getStudentId());
		paramMap.put("name", student.getStudentName());
		paramMap.put("ogrnumber", student.getStudentNumber());
		paramMap.put("year", student.getStudentYear());
		try {
			return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
		} catch (DuplicateKeyException e) {
			throw new BusinessException("There is a student at the database with same student number!");
		}
		
	}

	@Override
	public boolean delete(long studentId) {
		String sql = "delete from obsh.ogrenci where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", studentId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	@Override
	public Student getById(long studentId) {
		String sql = "select * from obsh.ogrenci where (id)=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", studentId);
		try {
			Student student = (Student) namedParameterJdbcTemplate.queryForObject(sql, paramMap,
					new StudentRowMapper());
			return student;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Student getByName(String studentName) {
		String sql = "select * from obsh.ogrenci where upper(name) like upper(:name)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", studentName);
		try {
			Student student = (Student) namedParameterJdbcTemplate.queryForObject(sql, paramMap,
					new StudentRowMapper());
			return student;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Student getByStudentNumber(long studentNumber) {
		String sql = "select * from obsh.ogrenci where (ogrnumber)=:ogrnumber";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ogrnumber", studentNumber);
		try {
			Student student = (Student) namedParameterJdbcTemplate.queryForObject(sql, paramMap,
					new StudentRowMapper());
			return student;
		} catch (Exception e) {
			return null;
		}
	}




	
}
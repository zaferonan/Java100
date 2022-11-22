package com.turkcell.OBS.repository.abstracts;

import java.util.List;

import com.turkcell.OBS.model.Student;

public interface IStudentRepository {

	public List<Student> getAll();
	public boolean add(Student student);
	public boolean update(Student student);
	public boolean delete(long studentId);
	public Student getById(long studentId);
	public Student getByName(String studentName);
	public Student getByStudentNumber(long studentNumber);
	
}

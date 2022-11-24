package com.turkcell.OBS.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OBS.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {

	public Student getById(long studentId);
	public Student getByStudentNumber(long studentNumber);
	public boolean existsByStudentNumber(long studentNumber);
	public boolean existsByStudentNameIgnoreCase(String studentName);
	public Student getByStudentNameIgnoreCase(String studentName);
	
}

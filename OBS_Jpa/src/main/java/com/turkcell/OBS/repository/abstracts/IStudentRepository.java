package com.turkcell.OBS.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OBS.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {

	public Student getById(long studentId);
	public Student getByStudentName(String studentName);
	public Student getByStudentNumber(long studentNumber);
	
}

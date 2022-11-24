package com.turkcell.OBS.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OBS.model.Teacher;

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
	
	public Teacher getById(long teacherId);
	public Teacher getByTeacherNameIgnoreCase(String teacherName);
	public boolean existsByTeacherNameIgnoreCase(String teacherName);
	
}

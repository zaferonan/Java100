package com.turkcell.OBS.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.model.CourseStudent;
import com.turkcell.OBS.model.Student;

public interface ICourseStudentRepository extends JpaRepository<CourseStudent, Long>{
	
	public CourseStudent getById(long courseStudentId);	
	public boolean existsByCourseAndStudent(Course course,Student student);
	
}

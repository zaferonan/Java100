package com.turkcell.OBS.repository.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.model.CourseStudent;
import com.turkcell.OBS.model.Student;
import com.turkcell.OBS.model.Subject;
import com.turkcell.OBS.model.Teacher;

public interface ICourseStudentRepository extends JpaRepository<CourseStudent, Long>{
	
	public CourseStudent getById(long courseStudentId);
	
	public List<CourseStudent> getByCourse(Course course);	
	public List<CourseStudent> getByStudent(Student student);
	public boolean existsByCourseAndStudent(Course course,Student student);
	
}

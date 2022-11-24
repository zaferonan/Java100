package com.turkcell.OBS.repository.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.model.Subject;
import com.turkcell.OBS.model.Teacher;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long>{
		
	public Course getById(long courseId);
	public List<Course> getByTeacher(long teacherId);
	public List<Course> getBySubject(long subjectId);
	public boolean existsBySubjectAndTeacher(Subject subject,Teacher teacher);

}

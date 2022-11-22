package com.turkcell.OBS.repository.abstracts;

import java.util.List;

import com.turkcell.OBS.model.CourseStudent;

public interface ICourseStudentRepository {

	public List<CourseStudent> getAll();
	public boolean add(CourseStudent courseStudent);
	public boolean update(CourseStudent courseStudent);
	public boolean delete(long courseStudentId);
	public CourseStudent getById(long courseStudentId);
	public boolean isExists(CourseStudent courseStudent);
	public List<CourseStudent> getByCourse(long courseId);
	public List<CourseStudent> getByStudent(long studentId);
	
}

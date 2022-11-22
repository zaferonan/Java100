package com.turkcell.OBS.repository.abstracts;

import java.util.List;

import com.turkcell.OBS.model.Course;

public interface ICourseRepository {

	public List<Course> getAll();
	public boolean add(Course course);
	public boolean update(Course course);
	public boolean delete(long courseId);
	public Course getById(long courseId);
	public List<Course> getByTeacher(long teacherId);
	public List<Course> getBySubject(long subjectId);
	public boolean isExists(Course course);
}

package com.turkcell.OBS.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.service.dtos.course.CourseDto;
import com.turkcell.OBS.service.dtos.course.ListCourseDto;

public interface CourseService {

	public ResponseEntity<List<ListCourseDto>> getAll();
	public ResponseEntity<String> add(Course course);
	public ResponseEntity<String> update(Course course);
	public ResponseEntity<String> delete(long courseId);
	public ResponseEntity<CourseDto> getById(long courseId);
	public ResponseEntity<List<ListCourseDto>> getByTeacher(long teacherId);
	public ResponseEntity<List<ListCourseDto>> getBySubject(long subjectId);
	
}

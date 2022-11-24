package com.turkcell.OBS.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.service.dtos.course.CourseDto;
import com.turkcell.OBS.service.dtos.course.ListCourseDto;
import com.turkcell.OBS.service.requests.create.CreateCourseRequest;
import com.turkcell.OBS.service.requests.update.UpdateCourseRequest;

public interface CourseService {

	public ResponseEntity<List<ListCourseDto>> getAll();
	public ResponseEntity<String> add(CreateCourseRequest createCourseRequest);
	public ResponseEntity<String> update(UpdateCourseRequest updateCourseRequest);
	public ResponseEntity<String> delete(long courseId);
	public ResponseEntity<CourseDto> getById(long courseId);
	public ResponseEntity<List<ListCourseDto>> getByTeacher(long teacherId);
	public ResponseEntity<List<ListCourseDto>> getBySubject(long subjectId);
	public Course getByIdAsCourse(long courseId);
	
}

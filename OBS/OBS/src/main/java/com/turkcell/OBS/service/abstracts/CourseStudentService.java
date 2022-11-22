package com.turkcell.OBS.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.OBS.model.CourseStudent;
import com.turkcell.OBS.service.dtos.courseStudent.CourseStudentDto;
import com.turkcell.OBS.service.dtos.courseStudent.ListCourseStudentDto;

public interface CourseStudentService {

	public ResponseEntity<List<ListCourseStudentDto>> getAll();
	public ResponseEntity<String> add(CourseStudent courseStudent);
	public ResponseEntity<String> update(CourseStudent courseStudent);
	public ResponseEntity<String> delete(long courseStudentId);
	public ResponseEntity<CourseStudentDto> getById(long courseStudentId);
	public ResponseEntity<List<ListCourseStudentDto>> getByCourse(long courseId);
	public ResponseEntity<List<ListCourseStudentDto>> getByStudent(long studentId);
}

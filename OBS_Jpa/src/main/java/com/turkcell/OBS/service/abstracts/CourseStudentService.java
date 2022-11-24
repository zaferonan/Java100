package com.turkcell.OBS.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.OBS.service.dtos.courseStudent.CourseStudentDto;
import com.turkcell.OBS.service.dtos.courseStudent.ListCourseStudentDto;
import com.turkcell.OBS.service.requests.create.CreateCourseStudentRequest;
import com.turkcell.OBS.service.requests.update.UpdateCourseStudentRequest;

public interface CourseStudentService {

	public ResponseEntity<List<ListCourseStudentDto>> getAll();
	public ResponseEntity<String> add(CreateCourseStudentRequest createCourseStudentRequest);
	public ResponseEntity<String> update(UpdateCourseStudentRequest updateCourseStudentRequest);
	public ResponseEntity<String> delete(long courseStudentId);
	public ResponseEntity<CourseStudentDto> getById(long courseStudentId);
	public ResponseEntity<List<ListCourseStudentDto>> getByCourse(long courseId);
	public ResponseEntity<List<ListCourseStudentDto>> getByStudent(long studentId);
}

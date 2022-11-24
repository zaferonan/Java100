package com.turkcell.OBS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.OBS.service.abstracts.CourseStudentService;
import com.turkcell.OBS.service.dtos.courseStudent.CourseStudentDto;
import com.turkcell.OBS.service.dtos.courseStudent.ListCourseStudentDto;
import com.turkcell.OBS.service.requests.create.CreateCourseStudentRequest;
import com.turkcell.OBS.service.requests.update.UpdateCourseStudentRequest;

@RestController
@RequestMapping("/api/courseStudent")
public class CourseStudentController {

	@Autowired
	private CourseStudentService courseStudentService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ListCourseStudentDto>> getAll() {
		return courseStudentService.getAll();
	}

	@GetMapping("/getById")
	public ResponseEntity<CourseStudentDto> getById(long courseStudentId) {
		return courseStudentService.getById(courseStudentId);
	}

	@GetMapping("/getByCourse")
	public ResponseEntity<List<ListCourseStudentDto>> getByCourse(long courseId) {
		return courseStudentService.getByCourse(courseId);
	}

	@GetMapping("/getByStudent")
	public ResponseEntity<List<ListCourseStudentDto>> getByStudent(long studentId) {
		return courseStudentService.getByStudent(studentId);
	}

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody CreateCourseStudentRequest createCourseStudentRequest) {
		return courseStudentService.add(createCourseStudentRequest);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int courseStudentId) {
		return courseStudentService.delete(courseStudentId);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody UpdateCourseStudentRequest updateCourseStudentRequest) {
		return courseStudentService.update(updateCourseStudentRequest);

	}
}

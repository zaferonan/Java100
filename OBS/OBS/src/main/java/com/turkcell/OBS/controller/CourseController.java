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

import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.service.abstracts.CourseService;
import com.turkcell.OBS.service.dtos.course.CourseDto;
import com.turkcell.OBS.service.dtos.course.ListCourseDto;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ListCourseDto>> getAll() {
		return courseService.getAll();
		
	}

	@GetMapping("/getById")
	public ResponseEntity<CourseDto> getById(@RequestParam long courseId) {
		return courseService.getById(courseId);
	}

	@GetMapping("/getByTeacher")
	public ResponseEntity<List<ListCourseDto>> getByTeacher(@RequestParam long teacherId) {
		return courseService.getByTeacher(teacherId);
	}

	@GetMapping("/getBySubject")
	public ResponseEntity<List<ListCourseDto>> getBySubject(@RequestParam long subjectId) {
		return courseService.getBySubject(subjectId);
	}

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Course course) {
		return courseService.add(course);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int courseId) {
		return courseService.delete(courseId);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Course course) {
		return courseService.update(course);

	}
}

package com.turkcell.OBS.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.turkcell.OBS.service.abstracts.CourseService;
import com.turkcell.OBS.service.dtos.course.CourseDto;
import com.turkcell.OBS.service.dtos.course.ListCourseDto;
import com.turkcell.OBS.service.requests.create.CreateCourseRequest;
import com.turkcell.OBS.service.requests.update.UpdateCourseRequest;

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
	public ResponseEntity<String> add(@Valid @RequestBody CreateCourseRequest createCourseRequest) {
		return courseService.add(createCourseRequest);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int courseId) {
		return courseService.delete(courseId);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody UpdateCourseRequest updateCourseRequest) {
		return courseService.update(updateCourseRequest);

	}
}

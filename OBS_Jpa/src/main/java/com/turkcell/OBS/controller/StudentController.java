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

import com.turkcell.OBS.service.abstracts.StudentService;
import com.turkcell.OBS.service.dtos.student.ListStudentDto;
import com.turkcell.OBS.service.dtos.student.StudentDto;
import com.turkcell.OBS.service.requests.create.CreateStudentRequest;
import com.turkcell.OBS.service.requests.update.UpdateStudentRequest;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ListStudentDto>> getAll() {
		return studentService.getAll();
	}

	@GetMapping("/getById")
	public ResponseEntity<StudentDto> getById(long studentId) {
		return studentService.getById(studentId);
	}

	@PostMapping("/add")
	public ResponseEntity<String> add(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.add(createStudentRequest);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int studentId) {
		return studentService.delete(studentId);

	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		return studentService.update(updateStudentRequest);
	}

	@GetMapping("/getByStudentNumber")
	public ResponseEntity<ListStudentDto> getByStudentNumber(@RequestParam long studentNumber) {
		return studentService.getByStudentNumber(studentNumber);
	}
	@GetMapping("/getByStudentName")
	public ResponseEntity<ListStudentDto> getByStudentName(@RequestParam String studentName){
		return studentService.getByStudentName(studentName);
	}

}
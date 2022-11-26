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

import com.turkcell.OBS.service.abstracts.TeacherService;
import com.turkcell.OBS.service.dtos.teacher.ListTeacherDto;
import com.turkcell.OBS.service.dtos.teacher.TeacherDto;
import com.turkcell.OBS.service.requests.create.CreateTeacherRequest;
import com.turkcell.OBS.service.requests.update.UpdateTeacherRequest;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListTeacherDto>> getAll(){
		return teacherService.getAll();
	}
	
	@GetMapping("/getById")
	public ResponseEntity<TeacherDto> getById(@RequestParam long teacherId) {
		return teacherService.getById(teacherId);
	}
	
	@GetMapping("/getByName")
	public ResponseEntity<ListTeacherDto> getByName(@RequestParam  String teacherName){
		return teacherService.getByName(teacherName);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@Valid @RequestBody CreateTeacherRequest createTeacherRequest) {
		return teacherService.add(createTeacherRequest); 
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int teacherId){
		return teacherService.delete(teacherId);			
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody UpdateTeacherRequest updateTeacherRequest){
		return teacherService.update(updateTeacherRequest);		
		
	}
}

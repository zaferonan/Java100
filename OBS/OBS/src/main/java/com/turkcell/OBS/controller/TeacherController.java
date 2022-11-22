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

import com.turkcell.OBS.model.Teacher;
import com.turkcell.OBS.service.abstracts.TeacherService;
import com.turkcell.OBS.service.dtos.teacher.ListTeacherDto;
import com.turkcell.OBS.service.dtos.teacher.TeacherDto;

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
	public ResponseEntity<TeacherDto> getById(long teacherId) {
		return teacherService.getById(teacherId);
	}
	
	@GetMapping("/getByName")
	public ResponseEntity<ListTeacherDto> getByName(String teacherName){
		return teacherService.getByName(teacherName);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Teacher teacher) {
		return teacherService.add(teacher); 
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int teacherId){
		return teacherService.delete(teacherId);			
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Teacher teacher){
		return teacherService.update(teacher);		
		
	}
}

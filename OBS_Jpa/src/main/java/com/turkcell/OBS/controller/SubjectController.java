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

import com.turkcell.OBS.service.abstracts.SubjectService;
import com.turkcell.OBS.service.dtos.subject.ListSubjectDto;
import com.turkcell.OBS.service.dtos.subject.SubjectDto;
import com.turkcell.OBS.service.requests.create.CreateSubjectRequest;
import com.turkcell.OBS.service.requests.update.UpdateSubjectRequest;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListSubjectDto>> getAll(){
		return subjectService.getAll();
	}
	
	@GetMapping("/getById")
	public ResponseEntity<SubjectDto> getById(@RequestParam long subjectId) {
		return subjectService.getById(subjectId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@Valid @RequestBody CreateSubjectRequest	createSubjectRequest) {
		return subjectService.add(createSubjectRequest);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int subjectId){
		return subjectService.delete(subjectId);	
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody UpdateSubjectRequest updateSubjectRequest){
		return subjectService.update(updateSubjectRequest);
	}
	
	@GetMapping("/getByName")
	public ResponseEntity<ListSubjectDto> getByName(@RequestParam String subjectName){
		return subjectService.getByName(subjectName);
	}
	

}

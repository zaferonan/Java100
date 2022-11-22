package com.turkcell.OBS.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.OBS.model.Subject;
import com.turkcell.OBS.service.dtos.subject.ListSubjectDto;
import com.turkcell.OBS.service.dtos.subject.SubjectDto;

public interface SubjectService {

	public ResponseEntity<List<ListSubjectDto>> getAll();
	public ResponseEntity<String> add(Subject subject);
	public ResponseEntity<String> update(Subject subject);
	public ResponseEntity<String> delete(long subjectId);
	public ResponseEntity<SubjectDto> getById(long subjectId);
	public ResponseEntity<ListSubjectDto> getByName(String subjectName);
	
}

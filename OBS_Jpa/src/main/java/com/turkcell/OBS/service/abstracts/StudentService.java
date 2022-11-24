package com.turkcell.OBS.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.OBS.model.Student;
import com.turkcell.OBS.service.dtos.student.ListStudentDto;
import com.turkcell.OBS.service.dtos.student.StudentDto;
import com.turkcell.OBS.service.requests.create.CreateStudentRequest;
import com.turkcell.OBS.service.requests.update.UpdateStudentRequest;

public interface StudentService {

	public ResponseEntity<List<ListStudentDto>> getAll();
	public ResponseEntity<String> add(CreateStudentRequest createStudentRequest);
	public ResponseEntity<String> update(UpdateStudentRequest updateStudentRequest);
	public ResponseEntity<String> delete(long studentId);
	public ResponseEntity<StudentDto> getById(long studentId);
	public ResponseEntity<ListStudentDto> getByStudentNumber(long studentId);
	public ResponseEntity<ListStudentDto> getByStudentName(String studentName);
	public Student getByIdAsStudent(long studentId);
	
}

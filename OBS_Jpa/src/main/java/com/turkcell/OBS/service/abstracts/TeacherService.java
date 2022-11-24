package com.turkcell.OBS.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.OBS.model.Teacher;
import com.turkcell.OBS.service.dtos.teacher.ListTeacherDto;
import com.turkcell.OBS.service.dtos.teacher.TeacherDto;
import com.turkcell.OBS.service.requests.create.CreateTeacherRequest;
import com.turkcell.OBS.service.requests.update.UpdateTeacherRequest;

public interface TeacherService {

	public ResponseEntity<List<ListTeacherDto>> getAll();
	public ResponseEntity<String> add(CreateTeacherRequest createTeacherRequest);
	public ResponseEntity<String> update(UpdateTeacherRequest updateTeacherRequest);
	public ResponseEntity<String> delete(long teacherId);
	public ResponseEntity<TeacherDto> getById(long teacherId);
	public ResponseEntity<ListTeacherDto> getByName(String teacherName);
	public Teacher getByIdAsTeacher(long teacherId);
}

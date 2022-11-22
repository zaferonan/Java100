package com.turkcell.OBS.service.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.turkcell.OBS.model.Teacher;
import com.turkcell.OBS.service.dtos.teacher.ListTeacherDto;
import com.turkcell.OBS.service.dtos.teacher.TeacherDto;

public interface TeacherService {

	public ResponseEntity<List<ListTeacherDto>> getAll();
	public ResponseEntity<String> add(Teacher teacher);
	public ResponseEntity<String> update(Teacher teacher);
	public ResponseEntity<String> delete(long teacherId);
	public ResponseEntity<TeacherDto> getById(long teacherId);
	public ResponseEntity<ListTeacherDto> getByName(String teacherName);
}

package com.turkcell.OBS.service.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.OBS.core.exceptions.BusinessException;
import com.turkcell.OBS.core.exceptions.mappers.abstracts.ModelMapperService;
import com.turkcell.OBS.model.Teacher;
import com.turkcell.OBS.repository.abstracts.ITeacherRepository;
import com.turkcell.OBS.service.abstracts.TeacherService;
import com.turkcell.OBS.service.dtos.course.ListCourseDto;
import com.turkcell.OBS.service.dtos.teacher.ListTeacherDto;
import com.turkcell.OBS.service.dtos.teacher.TeacherDto;
import com.turkcell.OBS.service.requests.create.CreateTeacherRequest;
import com.turkcell.OBS.service.requests.update.UpdateTeacherRequest;

@Service
public class TeacherManager implements TeacherService {

	@Autowired
	private ITeacherRepository iTeacherRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public ResponseEntity<List<ListTeacherDto>> getAll() {
		List<Teacher> teachers = iTeacherRepository.findAll();
		
		List<ListTeacherDto> listTeacherDtos = teachers.stream()
				.map(teacher -> this.modelMapperService.forDto().map(teacher, ListTeacherDto.class))
				.collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(listTeacherDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateTeacherRequest createTeacherRequest) {

		iTeacherRepository.save(createTeacherRequest.toTeacher());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Teacher " + createTeacherRequest.getTeacherName() + "  is saved in the database.");

	}

	@Override
	public ResponseEntity<String> update(UpdateTeacherRequest updateTeacherRequest) {
		if (!isExistById(updateTeacherRequest.getTeacherId())) {
			throw new BusinessException("There is no teacher with this id : " + updateTeacherRequest.getTeacherId());
		}
		iTeacherRepository.save(updateTeacherRequest.toTeacher());
		return ResponseEntity.ok("Teacher " + updateTeacherRequest.getTeacherName() + " is updated in the database.");

	}

	@Override
	public ResponseEntity<String> delete(long teacherId) {
		if (!isExistById(teacherId)) {
			throw new BusinessException("There is no teacher with this id : " + teacherId);
		}
		iTeacherRepository.deleteById(teacherId);
		return ResponseEntity.ok("Teacher is deleted from the database.");

	}

	@Override
	public ResponseEntity<TeacherDto> getById(long teacherId) {
		if (!isExistById(teacherId)) {
			throw new BusinessException("There is no teacher with this id : " + teacherId);
		}
		Teacher teacher = iTeacherRepository.getById(teacherId);
		TeacherDto teacherDto = this.modelMapperService.forDto().map(teacher, TeacherDto.class);
		
		
		return ResponseEntity.ok(teacherDto);

	}

	@Override
	public ResponseEntity<ListTeacherDto> getByName(String teacherName) {
		if (!isExistByName(teacherName)) {
			throw new BusinessException("There is no teacher with this name : " + teacherName);
		}
		Teacher teacher = iTeacherRepository.getByTeacherName(teacherName);
		
		ListTeacherDto teacherDto = this.modelMapperService.forDto().map(teacher, ListTeacherDto.class);		
		
		return ResponseEntity.ok(teacherDto);
	}

	private boolean isExistByName(String teacherName) {

		return iTeacherRepository.getByTeacherName(teacherName) != null;
	}

	private boolean isExistById(long teacherId) {

		return iTeacherRepository.getById(teacherId) != null;
	}

	@Override
	public Teacher getByIdAsTeacher(long teacherId) {
		if (!isExistById(teacherId)) {
			throw new BusinessException("There is no teacher with this id : " + teacherId);
		}
		return iTeacherRepository.getById(teacherId);
	}

}

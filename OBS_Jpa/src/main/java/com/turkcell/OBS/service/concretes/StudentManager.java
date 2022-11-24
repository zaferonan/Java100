package com.turkcell.OBS.service.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.OBS.core.exceptions.BusinessException;
import com.turkcell.OBS.core.mappers.abstracts.ModelMapperService;
import com.turkcell.OBS.model.Student;
import com.turkcell.OBS.repository.abstracts.IStudentRepository;
import com.turkcell.OBS.service.abstracts.StudentService;
import com.turkcell.OBS.service.dtos.student.ListStudentDto;
import com.turkcell.OBS.service.dtos.student.StudentDto;
import com.turkcell.OBS.service.requests.create.CreateStudentRequest;
import com.turkcell.OBS.service.requests.update.UpdateStudentRequest;

@Service
public class StudentManager implements StudentService {

	@Autowired
	private IStudentRepository iStudentRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public ResponseEntity<List<ListStudentDto>> getAll() {
		List<Student> students = iStudentRepository.findAll();
		
		List<ListStudentDto> listStudentDtos = students.stream()
				.map(student -> this.modelMapperService.forDto().map(student, ListStudentDto.class))
				.collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(listStudentDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateStudentRequest createStudentRequest) {
		if (isExistByStudentNumber(createStudentRequest.getStudentNumber())) {
			throw new BusinessException("There is a student with same student number!");
		}
		iStudentRepository.save(this.modelMapperService.forRequest().map(createStudentRequest, Student.class));
		return ResponseEntity.status(HttpStatus.CREATED).body("Student is saved.");

	}

	@Override
	public ResponseEntity<String> update(UpdateStudentRequest updateStudentRequest) {
		if (!isExistById(updateStudentRequest.getStudentId())) {
			throw new BusinessException("There is no student with this id : " + updateStudentRequest.getStudentId());
		}
		iStudentRepository.save(this.modelMapperService.forRequest().map(updateStudentRequest, Student.class));
		return ResponseEntity.ok("Student " + updateStudentRequest.getStudentName() + " is updated in the database.");

	}

	@Override
	public ResponseEntity<String> delete(long studentId) {
		if (!isExistById(studentId)) {
			throw new BusinessException("There is no student with this id : " + studentId);
		}
		iStudentRepository.deleteById(studentId);
		return ResponseEntity.ok("Student is deleted from the database.");

	}

	@Override
	public ResponseEntity<StudentDto> getById(long studentId) {
		if (!isExistById(studentId)) {
			throw new BusinessException("There is no student with this id : " + studentId);
		}
		Student student = iStudentRepository.getById(studentId);

		StudentDto studentDto = this.modelMapperService.forDto().map(student, StudentDto.class);

		return ResponseEntity.status(HttpStatus.OK).body(studentDto);
	}

	@Override
	public ResponseEntity<ListStudentDto> getByStudentNumber(long studentNumber) {

		if (!isExistByStudentNumber(studentNumber)) {
			throw new BusinessException("There is no student with this student number : " + studentNumber);
		}

		Student student = iStudentRepository.getByStudentNumber(studentNumber);

		ListStudentDto studentDto = this.modelMapperService.forDto().map(student, ListStudentDto.class);

		return ResponseEntity.status(HttpStatus.OK).body(studentDto);
	}

	@Override
	public ResponseEntity<ListStudentDto> getByStudentName(String studentName) {
		if (!isExistByName(studentName)) {
			throw new BusinessException("There is no student with this name : " + studentName + "!");
		}
		Student student = iStudentRepository.getByStudentNameIgnoreCase(studentName);

		ListStudentDto listStudentDto = this.modelMapperService.forDto().map(student, ListStudentDto.class);

		return ResponseEntity.status(HttpStatus.OK).body(listStudentDto);
	}

	@Override
	public Student getByIdAsStudent(long studentId) {
		if (!isExistById(studentId)) {
			throw new BusinessException("There is no student with this id : " + studentId);
		}
		return iStudentRepository.getById(studentId);
	}

	private boolean isExistById(long studentId) {

		return iStudentRepository.existsById(studentId);
	}

	private boolean isExistByName(String studentName) {

		return iStudentRepository.existsByStudentNameIgnoreCase(studentName);
	}

	private boolean isExistByStudentNumber(long studentNumber) {

		return iStudentRepository.existsByStudentNumber(studentNumber);
	}

}
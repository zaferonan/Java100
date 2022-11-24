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
import com.turkcell.OBS.model.CourseStudent;
import com.turkcell.OBS.repository.abstracts.ICourseStudentRepository;
import com.turkcell.OBS.service.abstracts.CourseService;
import com.turkcell.OBS.service.abstracts.CourseStudentService;
import com.turkcell.OBS.service.abstracts.StudentService;
import com.turkcell.OBS.service.dtos.courseStudent.CourseStudentDto;
import com.turkcell.OBS.service.dtos.courseStudent.ListCourseStudentDto;
import com.turkcell.OBS.service.requests.create.CreateCourseStudentRequest;
import com.turkcell.OBS.service.requests.update.UpdateCourseStudentRequest;

import net.bytebuddy.asm.Advice.This;

@Service
public class CourseStudentManager implements CourseStudentService {

	@Autowired
	private ICourseStudentRepository iCourseStudentRepository;
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public ResponseEntity<List<ListCourseStudentDto>> getAll() {
		List<CourseStudent> courseStudents = iCourseStudentRepository.findAll();

		List<ListCourseStudentDto> listCourseStudentDtos = courseStudents.stream()
				.map(courseStudent -> this.modelMapperService.forDto().map(courseStudent, ListCourseStudentDto.class))
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseStudentDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateCourseStudentRequest createCourseStudentRequest) {
		if (!isExistedCourse(createCourseStudentRequest.getCourseId())) {
			throw new BusinessException(
					"There is no course with this id : " + createCourseStudentRequest.getCourseId());
		} else if (!isExistedStudent(createCourseStudentRequest.getStudentId())) {
			throw new BusinessException("There is no student whit this id : "
					+ createCourseStudentRequest.getStudentId() + " in the database!");
		} else if (isExistedCourseStudent(createCourseStudentRequest.toCourseStudent(
				courseService.getByIdAsCourse(createCourseStudentRequest.getCourseId()),
				studentService.getByIdAsStudent(createCourseStudentRequest.getStudentId())))) {
			throw new BusinessException("This CourseStudent is already exists!!");
		}

		iCourseStudentRepository
				.save(this.modelMapperService.forRequest().map(createCourseStudentRequest, CourseStudent.class));
		return ResponseEntity.status(HttpStatus.CREATED).body("CourseStudent is saved in the database.");

	}

	@Override
	public ResponseEntity<String> update(UpdateCourseStudentRequest updateCourseStudentRequest) {
		if (!isExistById(updateCourseStudentRequest.getCourseStudentId())) {
			throw new BusinessException(
					"There is no CourseStudent with this id : " + updateCourseStudentRequest.getCourseStudentId());
		} else if (!isExistedCourse(updateCourseStudentRequest.getCourseId())) {
			throw new BusinessException(
					"There is no course with this id : " + updateCourseStudentRequest.getCourseId());
		} else if (!isExistedStudent(updateCourseStudentRequest.getStudentId())) {
			throw new BusinessException(
					"There is no student with this id : " + updateCourseStudentRequest.getStudentId());
		}
		iCourseStudentRepository
				.save(this.modelMapperService.forRequest().map(updateCourseStudentRequest, CourseStudent.class));
		return ResponseEntity.ok("CourseStudent is updated in the database.");

	}

	@Override
	public ResponseEntity<String> delete(long courseStudentId) {
		if (!isExistById(courseStudentId)) {
			throw new BusinessException("There is no CourseStudent with this id : " + courseStudentId);
		}
		iCourseStudentRepository.deleteById(courseStudentId);
		return ResponseEntity.ok("CourseStudent is deleted from the database.");

	}

	@Override
	public ResponseEntity<CourseStudentDto> getById(long courseStudentId) {
		if (!isExistById(courseStudentId)) {
			throw new BusinessException("There is no CourseStudent with this id : " + courseStudentId);
		}
		CourseStudent courseStudent = iCourseStudentRepository.getById(courseStudentId);
		CourseStudentDto courseStudentDto = this.modelMapperService.forDto().map(courseStudent, CourseStudentDto.class);
		return ResponseEntity.status(HttpStatus.FOUND).body(courseStudentDto);

	}

	@Override
	public ResponseEntity<List<ListCourseStudentDto>> getByCourse(long courseId) {
		if (!isExistedCourse(courseId)) {
			throw new BusinessException("There is no course with this id : " + courseId);
		}

		List<CourseStudent> courseStudents = iCourseStudentRepository.findAll().stream()
				.filter(c -> c.getCourse().getCourseId() == courseId).collect(Collectors.toList());
		if (courseStudents.isEmpty()) {
			throw new BusinessException("There is no courseStudents with this course id : " + courseId);
		}
		List<ListCourseStudentDto> listCourseStudentDtos = courseStudents.stream()
				.map(courseStudent -> this.modelMapperService.forDto().map(courseStudent, ListCourseStudentDto.class))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseStudentDtos);
	}

	@Override
	public ResponseEntity<List<ListCourseStudentDto>> getByStudent(long studentId) {
		if (!isExistedStudent(studentId)) {
			throw new BusinessException("There is no student with this id : " + studentId);
		}
		List<CourseStudent> courseStudents = iCourseStudentRepository.findAll().stream()
				.filter(c -> c.getStudent().getStudentId() == studentId).collect(Collectors.toList());

		if (courseStudents.isEmpty()) {
			throw new BusinessException("There is no courseStudent with this student id : " + studentId);
		}
		List<ListCourseStudentDto> listCourseStudentDtos = courseStudents.stream()
				.map(courseStudent -> this.modelMapperService.forDto().map(courseStudent, ListCourseStudentDto.class))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseStudentDtos);
	}

	private boolean isExistById(long courseStudentId) {

		return iCourseStudentRepository.getById(courseStudentId) != null;
	}

	private boolean isExistedStudent(long courseStudentStudentId) {

		return studentService.getById(courseStudentStudentId) != null;
	}

	private boolean isExistedCourse(long courseStudentCourseId) {

		return courseService.getById(courseStudentCourseId) != null;
	}

	private boolean isExistedCourseStudent(CourseStudent courseStudent) {

		return iCourseStudentRepository.existsByCourseAndStudent(courseStudent.getCourse(), courseStudent.getStudent());
	}

}
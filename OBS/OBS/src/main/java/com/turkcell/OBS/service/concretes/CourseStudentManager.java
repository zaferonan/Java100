package com.turkcell.OBS.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.OBS.core.exceptions.BusinessException;
import com.turkcell.OBS.model.CourseStudent;
import com.turkcell.OBS.repository.abstracts.ICourseStudentRepository;
import com.turkcell.OBS.service.abstracts.CourseService;
import com.turkcell.OBS.service.abstracts.CourseStudentService;
import com.turkcell.OBS.service.abstracts.StudentService;
import com.turkcell.OBS.service.dtos.courseStudent.CourseStudentDto;
import com.turkcell.OBS.service.dtos.courseStudent.ListCourseStudentDto;

@Service
public class CourseStudentManager implements CourseStudentService {

	@Autowired
	private ICourseStudentRepository iCourseStudentRepository;
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;

	@Override
	public ResponseEntity<List<ListCourseStudentDto>> getAll() {
		List<CourseStudent> courseStudents = iCourseStudentRepository.getAll();
		List<ListCourseStudentDto> listCourseStudentDtos = new ArrayList<>();
		for (CourseStudent courseStudent : courseStudents) {
			ListCourseStudentDto listCourseStudentDto = new ListCourseStudentDto();
			listCourseStudentDto.setCourseStudentId(courseStudent.getCourseStudentId());
			listCourseStudentDto.setCourseStudentAbsence(courseStudent.getCourseStudentAbsence());
			listCourseStudentDto.setCourseStudentNote(courseStudent.getCourseStudentNote());
			listCourseStudentDto.setCourseStudentCourseSubjectName(
					courseService.getById(courseStudent.getCourseStudentCourseId()).getBody().getCourseSubjectName());
			listCourseStudentDto.setCourseStudentCourseTeacherName(
					courseService.getById(courseStudent.getCourseStudentCourseId()).getBody().getCourseTeacherName());
			listCourseStudentDto.setCourseStudentStudentName(
					studentService.getById(courseStudent.getCourseStudentStudentId()).getBody().getStudentName());
			listCourseStudentDtos.add(listCourseStudentDto);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseStudentDtos);
	}

	@Override
	public ResponseEntity<String> add(CourseStudent courseStudent) {
		if (!isExistedCourse(courseStudent.getCourseStudentCourseId())) {
			throw new BusinessException("There is no course whit this id : " + courseStudent.getCourseStudentCourseId()
					+ " in the database!");
		} else if (!isExistedStudent(courseStudent.getCourseStudentStudentId())) {
			throw new BusinessException("There is no student whit this id : "
					+ courseStudent.getCourseStudentStudentId() + " in the database!");
		} else if (isExistedCourseStudent(courseStudent)) {
			throw new BusinessException("This CourseStudent is already exists!!");
		}
		if (iCourseStudentRepository.add(courseStudent)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("CourseStudent is saved in the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Could not save CourseStudent in the database!");
		}

	}

	// Update düzenlenecek!!
	@Override
	public ResponseEntity<String> update(CourseStudent courseStudent) {
		if(!isExistById(courseStudent.getCourseStudentId())) {
			throw new BusinessException("There is no CourseStudent with this id : " + courseStudent.getCourseStudentId());			
		}else if(!isExistedCourse(courseStudent.getCourseStudentCourseId())) {
			throw new BusinessException("There is no course with this id : " + courseStudent.getCourseStudentCourseId());
		}else if(!isExistedStudent(courseStudent.getCourseStudentStudentId())) {
			throw new BusinessException("There is no student with this id : " + courseStudent.getCourseStudentStudentId());
		}
		if(iCourseStudentRepository.update(courseStudent)) {
			return ResponseEntity.ok("CourseStudent is updated in the database.");
		}else {
			return ResponseEntity.internalServerError().body("Could not update the courseStudent in the database.");
		}

	}

	@Override
	public ResponseEntity<String> delete(long courseStudentId) {
		if (!isExistById(courseStudentId)) {
			throw new BusinessException("There is no CourseStudent with this id : " + courseStudentId);
		}
		if(iCourseStudentRepository.delete(courseStudentId)) {
			return ResponseEntity.ok("CourseStudent is deleted from the database.");
		}else {
			return ResponseEntity.internalServerError().body("Could not delete the courseStudent from the database.");
		}
	}

	@Override
	public ResponseEntity<CourseStudentDto> getById(long courseStudentId) {
		if (!isExistById(courseStudentId)) {
			throw new BusinessException("There is no CourseStudent with this id : " + courseStudentId);
		}
		CourseStudent courseStudent = iCourseStudentRepository.getById(courseStudentId);
		CourseStudentDto courseStudentDto = new CourseStudentDto();
		courseStudentDto.setCourseStudentAbsence(courseStudent.getCourseStudentAbsence());
		courseStudentDto.setCourseStudentNote(courseStudent.getCourseStudentNote());
		courseStudentDto.setCourseStudentCourseId(courseStudent.getCourseStudentCourseId());
		courseStudentDto.setCourseStudentCourseSubjectName(
				courseService.getById(courseStudent.getCourseStudentCourseId()).getBody().getCourseSubjectName());
		courseStudentDto.setCourseStudentCourseTeacherName(
				courseService.getById(courseStudent.getCourseStudentCourseId()).getBody().getCourseTeacherName());
		courseStudentDto.setCourseStudentStudentId(courseStudent.getCourseStudentId());
		courseStudentDto.setCourseStudentStudentName(
				studentService.getById(courseStudent.getCourseStudentStudentId()).getBody().getStudentName());
		return ResponseEntity.status(HttpStatus.FOUND).body(courseStudentDto);

	}
	
	@Override
	public ResponseEntity<List<ListCourseStudentDto>> getByCourse(long courseId) {
		if(!isExistedCourse(courseId)) {
			throw new BusinessException("There is no course with this id : " + courseId);
		}
		
		List<CourseStudent> courseStudents = iCourseStudentRepository.getByCourse(courseId);
		if (courseStudents.isEmpty()) {
			throw new BusinessException("There is no courseStudents with this course id : " + courseId);
		}
		List<ListCourseStudentDto> listCourseStudentDtos = new ArrayList<>();
		for (CourseStudent courseStudent : courseStudents) {
			ListCourseStudentDto listCourseStudentDto = new ListCourseStudentDto();
			listCourseStudentDto.setCourseStudentId(courseStudent.getCourseStudentId());
			listCourseStudentDto.setCourseStudentAbsence(courseStudent.getCourseStudentAbsence());
			listCourseStudentDto.setCourseStudentNote(courseStudent.getCourseStudentNote());
			listCourseStudentDto.setCourseStudentCourseSubjectName(
					courseService.getById(courseStudent.getCourseStudentCourseId()).getBody().getCourseSubjectName());
			listCourseStudentDto.setCourseStudentCourseTeacherName(
					courseService.getById(courseStudent.getCourseStudentCourseId()).getBody().getCourseTeacherName());
			listCourseStudentDto.setCourseStudentStudentName(
					studentService.getById(courseStudent.getCourseStudentStudentId()).getBody().getStudentName());
			listCourseStudentDtos.add(listCourseStudentDto);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseStudentDtos);
	}

	@Override
	public ResponseEntity<List<ListCourseStudentDto>> getByStudent(long studentId) {
		if(!isExistedStudent(studentId)) {
			throw new BusinessException("There is no student with this id : " + studentId);
		}
		List<CourseStudent> courseStudents = iCourseStudentRepository.getByStudent(studentId);
		if (courseStudents.isEmpty()) {
			throw new BusinessException("There is no courseStudent with this student id : " + studentId);
		}
		List<ListCourseStudentDto> listCourseStudentDtos = new ArrayList<>();
		for (CourseStudent courseStudent : courseStudents) {
			ListCourseStudentDto listCourseStudentDto = new ListCourseStudentDto();
			listCourseStudentDto.setCourseStudentId(courseStudent.getCourseStudentId());
			listCourseStudentDto.setCourseStudentAbsence(courseStudent.getCourseStudentAbsence());
			listCourseStudentDto.setCourseStudentNote(courseStudent.getCourseStudentNote());
			listCourseStudentDto.setCourseStudentCourseSubjectName(
					courseService.getById(courseStudent.getCourseStudentCourseId()).getBody().getCourseSubjectName());
			listCourseStudentDto.setCourseStudentCourseTeacherName(
					courseService.getById(courseStudent.getCourseStudentCourseId()).getBody().getCourseTeacherName());
			listCourseStudentDto.setCourseStudentStudentName(
					studentService.getById(courseStudent.getCourseStudentStudentId()).getBody().getStudentName());
			listCourseStudentDtos.add(listCourseStudentDto);
		}
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

		return iCourseStudentRepository.isExists(courseStudent);
	}



}
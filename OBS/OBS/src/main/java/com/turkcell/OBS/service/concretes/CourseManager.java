package com.turkcell.OBS.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.OBS.core.exceptions.BusinessException;
import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.repository.abstracts.ICourseRepository;
import com.turkcell.OBS.service.abstracts.CourseService;
import com.turkcell.OBS.service.abstracts.SubjectService;
import com.turkcell.OBS.service.abstracts.TeacherService;
import com.turkcell.OBS.service.dtos.course.CourseDto;
import com.turkcell.OBS.service.dtos.course.ListCourseDto;

@Service
public class CourseManager implements CourseService {

	@Autowired
	private ICourseRepository iCourseRepository;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SubjectService subjectService;

	@Override
	public ResponseEntity<List<ListCourseDto>> getAll() {
		List<Course> courses = iCourseRepository.getAll();
		List<ListCourseDto> listCourseDtos = new ArrayList<ListCourseDto>();
		for (Course course : courses) {
			ListCourseDto listCourseDto = new ListCourseDto();
			listCourseDto.setCourseId(course.getCourseId());
			listCourseDto.setCourseTeacherName(
					teacherService.getById(course.getCourseTeacherId()).getBody().getTeacherName());
			listCourseDto.setCourseSubjectName(
					subjectService.getById(course.getCourseSubjectId()).getBody().getSubjectName());
			listCourseDtos.add(listCourseDto);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseDtos);
	}

	@Override
	public ResponseEntity<String> add(Course course) {
		if (!isExistedTeacher(course.getCourseTeacherId())) {
			throw new BusinessException(
					"There is no teacher whit this id : " + course.getCourseTeacherId() + " in the database!");
		} else if (!isExistedSubject(course.getCourseSubjectId())) {
			throw new BusinessException(
					"There is no subject whit this id : " + course.getCourseSubjectId() + " in the database!");
		}else if(isExistedCourse(course)) {
			throw new BusinessException("This Course is already exists!!");
		}
		if (iCourseRepository.add(course)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Course is saved in the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Could not save course in the database!");
		}

	}

	@Override
	public ResponseEntity<String> update(Course course) {
		if (!isExistById(course.getCourseId())) {
			throw new BusinessException(
					"There is no course whit this id : " + course.getCourseId() + " in the database!");
		} else if (!isExistedTeacher(course.getCourseTeacherId())) {
			throw new BusinessException(
					"There is no teacher whit this id : " + course.getCourseTeacherId() + " in the database!");
		} else if (!isExistedSubject(course.getCourseSubjectId())) {
			throw new BusinessException(
					"There is no subject whit this id : " + course.getCourseSubjectId() + " in the database!");
		}

		if (iCourseRepository.update(course)) {
			return ResponseEntity.status(HttpStatus.OK).body("Course is updated in the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Could not save course in the database!");
		}

	}

	@Override
	public ResponseEntity<String> delete(long courseId) {
		if (!isExistById(courseId)) {
			throw new BusinessException("There is no course whit this id : " + courseId + " in the database!");
		}
		if (iCourseRepository.delete(courseId)) {
			return ResponseEntity.status(HttpStatus.OK).body("Course is deleted from the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Could not delete the course from the database.");
		}

	}

	@Override
	public ResponseEntity<CourseDto> getById(long courseId) {
		if (!isExistById(courseId)) {
			throw new BusinessException("There is no course with this id : " + courseId);
		}
		
		Course course = iCourseRepository.getById(courseId);

		CourseDto courseDto = new CourseDto();
		courseDto.setCourseSubjectId(course.getCourseSubjectId());
		courseDto.setCourseSubjectName(subjectService.getById(course.getCourseSubjectId()).getBody().getSubjectName());
		courseDto.setCourseTeacherId(course.getCourseTeacherId());
		courseDto.setCourseTeacherName(teacherService.getById(course.getCourseTeacherId()).getBody().getTeacherName());

		return ResponseEntity.status(HttpStatus.FOUND).body(courseDto);
	}

	@Override
	public ResponseEntity<List<ListCourseDto>> getByTeacher(long teacherId) {

		if (!isExistedTeacher(teacherId)) {
			throw new BusinessException("There is no teacher whit this id : " + teacherId + " in the database!");
		}
		
		List<Course> courses = iCourseRepository.getByTeacher(teacherId);
		
		if (courses.isEmpty()) {
			throw new BusinessException("There is no course with this teacher id : " + teacherId);
		}
		
		List<ListCourseDto> listCourseDtos = new ArrayList<ListCourseDto>();
		for (Course course : courses) {
			ListCourseDto listCourseDto = new ListCourseDto();
			listCourseDto.setCourseId(course.getCourseId());
			listCourseDto.setCourseTeacherName(
					teacherService.getById(course.getCourseTeacherId()).getBody().getTeacherName());
			listCourseDto.setCourseSubjectName(
					subjectService.getById(course.getCourseSubjectId()).getBody().getSubjectName());
			listCourseDtos.add(listCourseDto);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseDtos);
	}

	@Override
	public ResponseEntity<List<ListCourseDto>> getBySubject(long subjectId) {

		if (!isExistedSubject(subjectId)) {
			throw new BusinessException(
					"There is no subject whit this id : " + subjectId + " in the database!");
		}
		
		List<Course> courses = iCourseRepository.getBySubject(subjectId);
		if (courses.isEmpty()) {
			throw new BusinessException("There is no course with this subject id : " + subjectId);
		}
		List<ListCourseDto> listCourseDtos = new ArrayList<ListCourseDto>();
		for (Course course : courses) {
			ListCourseDto listCourseDto = new ListCourseDto();
			listCourseDto.setCourseId(course.getCourseId());
			listCourseDto.setCourseTeacherName(
					teacherService.getById(course.getCourseTeacherId()).getBody().getTeacherName());
			listCourseDto.setCourseSubjectName(
					subjectService.getById(course.getCourseSubjectId()).getBody().getSubjectName());
			listCourseDtos.add(listCourseDto);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseDtos);
	}

	private boolean isExistedSubject(long courseSubjectId) {

		return subjectService.getById(courseSubjectId) != null;
	}

	private boolean isExistedTeacher(long courseTeacherId) {

		return teacherService.getById(courseTeacherId) != null;
	}

	private boolean isExistById(long courseId) {

		return iCourseRepository.getById(courseId) != null;
	}
	private boolean isExistedCourse(Course course) {

		return iCourseRepository.isExists(course);
	}


}

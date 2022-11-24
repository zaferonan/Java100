package com.turkcell.OBS.service.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.OBS.core.exceptions.BusinessException;
import com.turkcell.OBS.core.mappers.abstracts.ModelMapperService;
import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.repository.abstracts.ICourseRepository;
import com.turkcell.OBS.service.abstracts.CourseService;
import com.turkcell.OBS.service.abstracts.SubjectService;
import com.turkcell.OBS.service.abstracts.TeacherService;
import com.turkcell.OBS.service.dtos.course.CourseDto;
import com.turkcell.OBS.service.dtos.course.ListCourseDto;
import com.turkcell.OBS.service.requests.create.CreateCourseRequest;
import com.turkcell.OBS.service.requests.update.UpdateCourseRequest;

@Service
public class CourseManager implements CourseService {

	@Autowired
	private ICourseRepository iCourseRepository;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public ResponseEntity<List<ListCourseDto>> getAll() {
		List<Course> courses = iCourseRepository.findAll();
		List<ListCourseDto> listCourseDtos = courses.stream()
				.map(course -> this.modelMapperService.forDto().map(course, ListCourseDto.class))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(listCourseDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateCourseRequest createCourseRequest) {
		if (!isExistedTeacher(createCourseRequest.getTeacherId())) {
			throw new BusinessException(
					"There is no teacher whit this id : " + createCourseRequest.getTeacherId() + " in the database!");
		} else if (!isExistedSubject(createCourseRequest.getSubjectId())) {
			throw new BusinessException(
					"There is no subject whit this id : " + createCourseRequest.getSubjectId() + " in the database!");
		} else if (isExistedCourse(
				this.modelMapperService.forRequest().map(createCourseRequest, Course.class))) {
			throw new BusinessException("This Course is already exists!!");
		}
		iCourseRepository.save(this.modelMapperService.forRequest().map(createCourseRequest, Course.class));
		return ResponseEntity.status(HttpStatus.CREATED).body("Course is saved in the database.");

	}

	@Override
	public ResponseEntity<String> update(UpdateCourseRequest updateCourseRequest) {
		if (!isExistById(updateCourseRequest.getCourseId())) {
			throw new BusinessException(
					"There is no course whit this id : " + updateCourseRequest.getCourseId() + " in the database!");
		} else if (!isExistedTeacher(updateCourseRequest.getTeacherId())) {
			throw new BusinessException(
					"There is no teacher whit this id : " + updateCourseRequest.getTeacherId() + " in the database!");
		} else if (!isExistedSubject(updateCourseRequest.getSubjectId())) {
			throw new BusinessException(
					"There is no subject whit this id : " + updateCourseRequest.getSubjectId() + " in the database!");
		}

		iCourseRepository.save(this.modelMapperService.forRequest().map(updateCourseRequest, Course.class));
		return ResponseEntity.status(HttpStatus.OK).body("Course is updated in the database.");

	}

	@Override
	public ResponseEntity<String> delete(long courseId) {
		if (!isExistById(courseId)) {
			throw new BusinessException("There is no course whit this id : " + courseId + " in the database!");
		}
		iCourseRepository.deleteById(courseId);
		return ResponseEntity.status(HttpStatus.OK).body("Course is deleted from the database.");

	}

	@Override
	public ResponseEntity<CourseDto> getById(long courseId) {
		if (!isExistById(courseId)) {
			throw new BusinessException("There is no course with this id : " + courseId);
		}

		Course course = iCourseRepository.getById(courseId);

		CourseDto courseDto = this.modelMapperService.forDto().map(course, CourseDto.class);

		return ResponseEntity.status(HttpStatus.OK).body(courseDto);
	}

	@Override
	public ResponseEntity<List<ListCourseDto>> getByTeacher(long teacherId) {

		if (!isExistedTeacher(teacherId)) {
			throw new BusinessException("There is no teacher whit this id : " + teacherId + " in the database!");
		}

		List<Course> courses = iCourseRepository.findAll().stream()
				.filter(c -> c.getTeacher().getTeacherId() == teacherId).collect(Collectors.toList());

		if (courses.isEmpty()) {
			throw new BusinessException("There is no course with this teacher id : " + teacherId);
		}

		List<ListCourseDto> listCourseDtos = courses.stream()
				.map(course -> this.modelMapperService.forDto().map(course, ListCourseDto.class))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseDtos);
	}

	@Override
	public ResponseEntity<List<ListCourseDto>> getBySubject(long subjectId) {

		if (!isExistedSubject(subjectId)) {
			throw new BusinessException("There is no subject whit this id : " + subjectId + " in the database!");
		}

		List<Course> courses = iCourseRepository.findAll().stream()
				.filter(c -> c.getSubject().getSubjectId() == subjectId).collect(Collectors.toList());
		if (courses.isEmpty()) {
			throw new BusinessException("There is no course with this subject id : " + subjectId);
		}
		List<ListCourseDto> listCourseDtos = courses.stream()
				.map(course -> this.modelMapperService.forDto().map(course, ListCourseDto.class))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseDtos);
	}

	@Override
	public Course getByIdAsCourse(long courseId) {
		if (!isExistById(courseId)) {
			throw new BusinessException("There is no course with this id : " + courseId);
		}

		return iCourseRepository.getById(courseId);
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

		return iCourseRepository.existsBySubjectAndTeacher(course.getSubject(), course.getTeacher());
	}

}

package com.turkcell.OBS.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.OBS.core.exceptions.BusinessException;
import com.turkcell.OBS.model.Subject;
import com.turkcell.OBS.repository.abstracts.ISubjectRepository;
import com.turkcell.OBS.service.abstracts.SubjectService;
import com.turkcell.OBS.service.dtos.course.ListCourseDto;
import com.turkcell.OBS.service.dtos.subject.ListSubjectDto;
import com.turkcell.OBS.service.dtos.subject.SubjectDto;
import com.turkcell.OBS.service.requests.create.CreateSubjectRequest;
import com.turkcell.OBS.service.requests.update.UpdateSubjectRequest;

@Service
public class SubjectManager implements SubjectService {

	@Autowired
	private ISubjectRepository iSubjectRepository;

	@Override
	public ResponseEntity<List<ListSubjectDto>> getAll() {

		List<Subject> subjects = iSubjectRepository.findAll();
		List<ListSubjectDto> listSubjectDtos = new ArrayList<ListSubjectDto>();
		for (Subject subject : subjects) {

			listSubjectDtos.add(subjectToListSubjectDto(subject));
		}

		return ResponseEntity.status(HttpStatus.FOUND).body(listSubjectDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateSubjectRequest createSubjectRequest) {
		if (isExistByName(createSubjectRequest.getSubjectName())) {
			throw new BusinessException("There is a subject with same name.");
		}
		iSubjectRepository.save(createSubjectRequest.toSubject());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Subject " + createSubjectRequest.getSubjectName() + " is saved in the database.");

	}

	@Override
	public ResponseEntity<String> update(UpdateSubjectRequest updateSubjectRequest) {
		if (!isExistById(updateSubjectRequest.getSubjectId())) {
			throw new BusinessException("There is no subject with this id : " + updateSubjectRequest.getSubjectId());
		}
		iSubjectRepository.save(updateSubjectRequest.toSubject());
		return ResponseEntity.ok("Subject " + updateSubjectRequest.getSubjectName() + " is updated.");

	}

	@Override
	public ResponseEntity<String> delete(long subjectId) {
		if (!isExistById(subjectId)) {
			throw new BusinessException("There is no subject with this id : " + subjectId);
		}
		iSubjectRepository.deleteById(subjectId);
		return ResponseEntity.ok("Subject is deleted.");

	}

	@Override
	public ResponseEntity<SubjectDto> getById(long subjectId) {
		if (!isExistById(subjectId)) {
			throw new BusinessException("There is no subject with this id : " + subjectId);
		}
		Subject subject = iSubjectRepository.getById(subjectId);

		return ResponseEntity.status(HttpStatus.FOUND).body(subjectToSubjectDto(subject));
	}

	@Override
	public ResponseEntity<ListSubjectDto> getByName(String subjectName) {
		if (!isExistByName(subjectName)) {
			throw new BusinessException("There is no subject with this name : " + subjectName);
		}
		Subject subject = iSubjectRepository.getBySubjectName(subjectName);

		return ResponseEntity.status(HttpStatus.FOUND).body(subjectToListSubjectDto(subject));
	}

	private boolean isExistByName(String subjectName) {

		return iSubjectRepository.getBySubjectName(subjectName) != null;
	}

	private boolean isExistById(long subjectId) {

		return iSubjectRepository.getById(subjectId) != null;
	}

	private SubjectDto subjectToSubjectDto(Subject subject) {
		SubjectDto subjectDto = new SubjectDto();

		subjectDto.setSubjectName(subject.getSubjectName());

		List<ListCourseDto> listCourseDtos = new ArrayList<ListCourseDto>();
		for (int i = 0; i < subject.getCourses().size(); i++) {
			ListCourseDto listCourseDto = new ListCourseDto(subject.getCourses().get(i).getCourseId(),
					subject.getCourses().get(i).getSubject().getSubjectName(),
					subject.getCourses().get(i).getTeacher().getTeacherName());
			listCourseDtos.add(listCourseDto);
		}
		subjectDto.setCourses(listCourseDtos);
		return subjectDto;
	}

	private ListSubjectDto subjectToListSubjectDto(Subject subject) {
		ListSubjectDto listSubjectDto = new ListSubjectDto();
		listSubjectDto.setSubjectId(subject.getSubjectId());
		listSubjectDto.setSubjectName(subject.getSubjectName());

		List<ListCourseDto> listCourseDtos = new ArrayList<ListCourseDto>();
		for (int i = 0; i < subject.getCourses().size(); i++) {
			ListCourseDto listCourseDto = new ListCourseDto(subject.getCourses().get(i).getCourseId(),
					subject.getCourses().get(i).getSubject().getSubjectName(),
					subject.getCourses().get(i).getTeacher().getTeacherName());
			listCourseDtos.add(listCourseDto);
		}		
		return listSubjectDto;
	}

	@Override
	public Subject getByIdAsSubject(long subjectId) {
		if (!isExistById(subjectId)) {
			throw new BusinessException("There is no subject with this id : " + subjectId);
		}
		return iSubjectRepository.getById(subjectId);
	}

}

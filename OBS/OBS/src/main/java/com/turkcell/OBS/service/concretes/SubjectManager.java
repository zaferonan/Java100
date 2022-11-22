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
import com.turkcell.OBS.service.dtos.subject.ListSubjectDto;
import com.turkcell.OBS.service.dtos.subject.SubjectDto;

@Service
public class SubjectManager implements SubjectService {

	@Autowired
	private ISubjectRepository iSubjectRepository;

	@Override
	public ResponseEntity<List<ListSubjectDto>> getAll() {

		List<Subject> subjects = iSubjectRepository.getAll();
		List<ListSubjectDto> listSubjectDtos = new ArrayList<ListSubjectDto>();

		for (Subject subject : subjects) {
			ListSubjectDto listSubjectDto = new ListSubjectDto(subject.getSubjectId(), subject.getSubjectName());

			listSubjectDtos.add(listSubjectDto);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(listSubjectDtos);
	}

	@Override
	public ResponseEntity<String> add(Subject subject) {
		if (isExistByName(subject.getSubjectName())) {
			throw new BusinessException("There is a subject with same name.");
		}
		if (iSubjectRepository.add(subject)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Subject "+subject.getSubjectName()+" is saved in the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Subject could not be saved.");
		}
	}

	@Override
	public ResponseEntity<String> update(Subject subject) {
		if (!isExistById(subject.getSubjectId())) {
			throw new BusinessException("There is no subject with this id : " + subject.getSubjectId());
		}
		if(iSubjectRepository.update(subject)) {
			return ResponseEntity.ok("Subject " + subject.getSubjectName() + " is updated.");

		} else {
			throw new BusinessException(subject.getSubjectName() + " could not be updated!");
		}
	}

	@Override
	public ResponseEntity<String> delete(long subjectId) {
		if (!isExistById(subjectId)) {
			throw new BusinessException("There is no subject with this id : " + subjectId);
		}
		if(iSubjectRepository.delete(subjectId)) {
			return ResponseEntity.ok("Subject is deleted.");
		}else {
			return ResponseEntity.internalServerError().body("Could not delete the subject.");
		}
	}

	@Override
	public ResponseEntity<SubjectDto> getById(long subjectId) {
		if (!isExistById(subjectId)) {
			throw new BusinessException("There is no subject with this id : " + subjectId);
		}
		Subject subject = iSubjectRepository.getById(subjectId);
		SubjectDto subjectDto = new SubjectDto(subject.getSubjectName());
		return ResponseEntity.status(HttpStatus.FOUND).body(subjectDto);
	}

	@Override
	public ResponseEntity<ListSubjectDto> getByName(String subjectName) {
		if (!isExistByName(subjectName)) {
			throw new BusinessException("There is no subject with this name : " + subjectName);
		}
		Subject subject = iSubjectRepository.getByName(subjectName);
		ListSubjectDto subjectDto = new ListSubjectDto(subject.getSubjectId(),subject.getSubjectName());
		return ResponseEntity.status(HttpStatus.FOUND).body(subjectDto);
	}
	


	private boolean isExistByName(String subjectName) {

		return iSubjectRepository.getByName(subjectName) != null;
	}

	private boolean isExistById(long subjectId) {

		return iSubjectRepository.getById(subjectId) != null;
	}

	

}

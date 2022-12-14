package com.turkcell.OBS.service.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.OBS.core.exceptions.BusinessException;
import com.turkcell.OBS.core.mappers.abstracts.ModelMapperService;
import com.turkcell.OBS.model.Subject;
import com.turkcell.OBS.repository.abstracts.ISubjectRepository;
import com.turkcell.OBS.service.abstracts.SubjectService;
import com.turkcell.OBS.service.dtos.subject.ListSubjectDto;
import com.turkcell.OBS.service.dtos.subject.SubjectDto;
import com.turkcell.OBS.service.requests.create.CreateSubjectRequest;
import com.turkcell.OBS.service.requests.update.UpdateSubjectRequest;

@Service
public class SubjectManager implements SubjectService {

	@Autowired
	private ISubjectRepository iSubjectRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public ResponseEntity<List<ListSubjectDto>> getAll() {

		List<Subject> subjects = iSubjectRepository.findAll();
		List<ListSubjectDto> listSubjectDtos = subjects.stream()
				.map(subject -> this.modelMapperService.forDto().map(subject, ListSubjectDto.class))
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(listSubjectDtos);
	}

	@Override
	public ResponseEntity<String> add(CreateSubjectRequest createSubjectRequest) {
		if (iSubjectRepository.existsBySubjectNameIgnoreCase(createSubjectRequest.getSubjectName())) {
			throw new BusinessException("There is a subject with same name.");
		}
		iSubjectRepository.save(this.modelMapperService.forRequest().map(createSubjectRequest, Subject.class));
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Subject " + createSubjectRequest.getSubjectName() + " is saved in the database.");

	}

	@Override
	public ResponseEntity<String> update(UpdateSubjectRequest updateSubjectRequest) {
		if (!isExistById(updateSubjectRequest.getSubjectId())) {
			throw new BusinessException("There is no subject with this id : " + updateSubjectRequest.getSubjectId());
		}
		iSubjectRepository.save(this.modelMapperService.forRequest().map(updateSubjectRequest, Subject.class));
		return ResponseEntity.status(HttpStatus.OK).body("Subject " + updateSubjectRequest.getSubjectName() + " is updated.");

	}

	@Override
	public ResponseEntity<String> delete(long subjectId) {
		if (!isExistById(subjectId)) {
			throw new BusinessException("There is no subject with this id : " + subjectId);
		}
		iSubjectRepository.deleteById(subjectId);
		return ResponseEntity.status(HttpStatus.OK).body("Subject is deleted.");

	}

	@Override
	public ResponseEntity<SubjectDto> getById(long subjectId) {
		if (!isExistById(subjectId)) {
			throw new BusinessException("There is no subject with this id : " + subjectId);
		}
		Subject subject = iSubjectRepository.getById(subjectId);

		SubjectDto subjectDto = this.modelMapperService.forDto().map(subject, SubjectDto.class);

		return ResponseEntity.status(HttpStatus.OK).body(subjectDto);
	}

	@Override
	public ResponseEntity<ListSubjectDto> getByName(String subjectName) {
		if (!iSubjectRepository.existsBySubjectNameIgnoreCase(subjectName)) {
			throw new BusinessException("There is no subject with this name : " + subjectName);
		}
		Subject subject = iSubjectRepository.getBySubjectNameIgnoreCase(subjectName);

		ListSubjectDto listSubjectDto = this.modelMapperService.forDto().map(subject, ListSubjectDto.class);

		return ResponseEntity.status(HttpStatus.OK).body(listSubjectDto);
	}

	

	private boolean isExistById(long subjectId) {

		return iSubjectRepository.existsById(subjectId);
	}

	@Override
	public Subject getByIdAsSubject(long subjectId) {
		if (!isExistById(subjectId)) {
			throw new BusinessException("There is no subject with this id : " + subjectId);
		}
		return iSubjectRepository.getById(subjectId);
	}

}

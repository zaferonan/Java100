package com.turkcell.OBS.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OBS.model.Subject;


public interface ISubjectRepository extends JpaRepository<Subject, Long>{
	
	public Subject getById(long subjectId);
	public Subject getBySubjectNameIgnoreCase(String subjectName);
	public boolean existsBySubjectNameIgnoreCase(String subjectName);
	
	
}

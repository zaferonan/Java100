package com.turkcell.OBS.repository.abstracts;

import java.util.List;

import com.turkcell.OBS.model.Subject;


public interface ISubjectRepository {

	public List<Subject> getAll();
	public boolean add(Subject subject);
	public boolean update(Subject subject);
	public boolean delete(long subjectId);
	public Subject getById(long subjectId);
	public Subject getByName(String subjectName);
	
	
}

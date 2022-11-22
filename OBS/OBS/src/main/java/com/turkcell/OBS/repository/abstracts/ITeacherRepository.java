package com.turkcell.OBS.repository.abstracts;

import java.util.List;

import com.turkcell.OBS.model.Teacher;

public interface ITeacherRepository {

	public List<Teacher> getAll();
	public boolean add(Teacher teacher);
	public boolean update(Teacher teacher);
	public boolean delete(long teacherId);
	public Teacher getById(long teacherId);
	public Teacher getByName(String teacherName);
}

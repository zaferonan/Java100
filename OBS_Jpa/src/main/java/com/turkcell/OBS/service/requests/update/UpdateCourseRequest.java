package com.turkcell.OBS.service.requests.update;

import javax.validation.constraints.NotNull;

import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.model.Subject;
import com.turkcell.OBS.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseRequest {
	
	@NotNull
	private long courseId;
	
	@NotNull
	private long subjectId;
	
	@NotNull
	private long teacherId;
	
	public Course toCourse(Subject subject,Teacher teacher) {
		Course course=new Course();
		course.setCourseId(this.courseId);
		course.setTeacher(teacher);
		course.setSubject(subject);
		return course;
	}
}

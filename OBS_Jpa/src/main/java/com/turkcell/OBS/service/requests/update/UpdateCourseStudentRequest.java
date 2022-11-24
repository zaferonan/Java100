package com.turkcell.OBS.service.requests.update;

import javax.validation.constraints.NotNull;

import com.turkcell.OBS.model.Course;
import com.turkcell.OBS.model.CourseStudent;
import com.turkcell.OBS.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseStudentRequest {

	@NotNull
	private long courseStudentId;
	@NotNull
	private int courseStudentAbsence;
	@NotNull
	private long courseStudentNote;
	@NotNull
	private long courseId;
	@NotNull
	private long studentId;
	
	public CourseStudent toCourseStudent(Course course,Student student) {
		CourseStudent courseStudent=new CourseStudent();
		courseStudent.setCourseStudentId(this.courseStudentId);
		courseStudent.setCourseStudentAbsence(this.courseStudentAbsence);
		courseStudent.setCourseStudentNote(this.courseStudentNote);
		courseStudent.setCourse(course);
		courseStudent.setStudent(student);
		return courseStudent;
	}
}

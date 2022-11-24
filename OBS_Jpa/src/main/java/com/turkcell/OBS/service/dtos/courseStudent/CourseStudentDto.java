package com.turkcell.OBS.service.dtos.courseStudent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentDto {

	private int courseStudentAbsence;
	private long courseStudentNote;
	private long courseStudentCourseId;	
	private String courseStudentCourseSubjectName;
	private String courseStudentCourseTeacherName;
	private long courseStudentStudentId;
	private String courseStudentStudentName;
	
}

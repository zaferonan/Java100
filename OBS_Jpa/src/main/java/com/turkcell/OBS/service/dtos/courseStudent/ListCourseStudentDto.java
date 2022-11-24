package com.turkcell.OBS.service.dtos.courseStudent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCourseStudentDto {

	private long courseStudentId;
	private int courseStudentAbsence;
	private long courseStudentNote;
	private String courseStudentCourseSubjectName;
	private String courseStudentCourseTeacherName;
	private String courseStudentStudentName;
}

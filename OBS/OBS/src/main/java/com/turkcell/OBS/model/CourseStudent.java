package com.turkcell.OBS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudent {

	private long courseStudentId;
	private int courseStudentAbsence;
	private long courseStudentNote;
	private long courseStudentCourseId;
	private long courseStudentStudentId;
}

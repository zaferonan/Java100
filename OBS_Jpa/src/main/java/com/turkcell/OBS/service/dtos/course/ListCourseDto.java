package com.turkcell.OBS.service.dtos.course;

import java.util.List;

import com.turkcell.OBS.service.dtos.courseStudent.ListCourseStudentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCourseDto {

	private long courseId;
	private String courseSubjectName;
	private String courseTeacherName;
	private List<ListCourseStudentDto> courseStudents;
	
	
}

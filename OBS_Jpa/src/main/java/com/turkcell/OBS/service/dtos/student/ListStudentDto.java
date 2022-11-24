package com.turkcell.OBS.service.dtos.student;



import java.util.List;

import com.turkcell.OBS.service.dtos.courseStudent.ListCourseStudentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListStudentDto {

	private long studentId;
	private String studentName;
	private long studentNumber;
	private int studentYear;
	private List<ListCourseStudentDto> courseStudents;
	
}

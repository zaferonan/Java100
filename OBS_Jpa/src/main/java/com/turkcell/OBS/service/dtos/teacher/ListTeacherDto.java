package com.turkcell.OBS.service.dtos.teacher;

import java.util.List;

import com.turkcell.OBS.service.dtos.course.ListCourseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListTeacherDto {

	private long teacherId;
	private boolean isGicik;
	private String teacherName;
	
	
}

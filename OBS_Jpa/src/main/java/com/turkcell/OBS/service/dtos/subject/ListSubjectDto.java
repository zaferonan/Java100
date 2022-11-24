package com.turkcell.OBS.service.dtos.subject;

import java.util.List;

import com.turkcell.OBS.service.dtos.course.ListCourseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSubjectDto {

	private long subjectId;
	private String subjectName;
	
	
}

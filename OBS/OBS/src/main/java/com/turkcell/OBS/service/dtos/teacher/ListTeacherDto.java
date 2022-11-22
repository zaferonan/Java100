package com.turkcell.OBS.service.dtos.teacher;

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

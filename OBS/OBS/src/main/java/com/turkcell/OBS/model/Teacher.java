package com.turkcell.OBS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

	private long teacherId;
	private boolean isGicik;
	private String teacherName;
	
}

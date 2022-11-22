package com.turkcell.OBS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

	private long courseId;
	private long courseSubjectId;
	private long courseTeacherId;
	
}

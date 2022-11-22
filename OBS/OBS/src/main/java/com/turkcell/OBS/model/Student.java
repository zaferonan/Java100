package com.turkcell.OBS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private long studentId;
	private String studentName;
	private long studentNumber;
	private int studentYear;
	
}

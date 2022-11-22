package com.turkcell.OBS.service.dtos.student;



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
}

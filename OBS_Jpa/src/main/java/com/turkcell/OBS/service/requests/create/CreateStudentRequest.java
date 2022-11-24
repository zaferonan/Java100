package com.turkcell.OBS.service.requests.create;

import javax.validation.constraints.NotNull;

import com.turkcell.OBS.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {

	@NotNull
	private String studentName;
	@NotNull
	private long studentNumber;
	@NotNull
	private int studentYear;
	
	public Student	toStudent() {
		Student student= new Student();
		student.setStudentName(this.studentName);
		student.setStudentNumber(this.studentNumber);
		student.setStudentYear(this.studentYear);
		return student;
		
	}
}

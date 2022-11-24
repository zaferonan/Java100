package com.turkcell.OBS.service.requests.update;

import javax.validation.constraints.NotNull;

import com.turkcell.OBS.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest {

	@NotNull
	private long studentId;
	@NotNull
	private String studentName;
	@NotNull
	private long studentNumber;
	@NotNull
	private int studentYear;
	
	public Student	toStudent() {
		Student student= new Student();
		student.setStudentId(this.studentId); 
		student.setStudentName(this.studentName);
		student.setStudentNumber(this.studentNumber);
		student.setStudentYear(this.studentYear);
		return student;
		
	}
}

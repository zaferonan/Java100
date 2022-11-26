package com.turkcell.OBS.service.requests.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseStudentRequest {

	@NotNull
	private int courseStudentAbsence;
	@NotNull
	private long courseStudentNote;
	@NotNull
	private long courseId;
	@NotNull
	private long studentId;
	

}

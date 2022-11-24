package com.turkcell.OBS.service.requests.update;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseStudentRequest {

	@NotNull
	private long courseStudentId;
	@NotNull
	private int courseStudentAbsence;
	@NotNull
	private long courseStudentNote;
	@NotNull
	private long courseId;
	@NotNull
	private long studentId;
	
}

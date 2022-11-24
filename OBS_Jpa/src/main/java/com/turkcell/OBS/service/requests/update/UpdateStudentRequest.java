package com.turkcell.OBS.service.requests.update;

import javax.validation.constraints.NotNull;

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

}

package com.turkcell.OBS.service.requests.create;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequest {

	@NotNull
	private long subjectId;
	
	@NotNull
	private long teacherId;
	
}

package com.turkcell.OBS.service.requests.update;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseRequest {
	
	@NotNull
	private long courseId;
	
	@NotNull
	private long subjectId;
	
	@NotNull
	private long teacherId;

}

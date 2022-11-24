package com.turkcell.OBS.service.requests.update;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTeacherRequest {

	@NotNull
	private long teacherId;

	@NotNull
	private String teacherName;

	@NotNull
	private boolean isGicik;
}

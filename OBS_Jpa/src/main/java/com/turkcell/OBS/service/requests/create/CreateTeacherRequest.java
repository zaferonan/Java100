package com.turkcell.OBS.service.requests.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeacherRequest {


	
	@NotBlank
	private String teacherName;
	

	@NotNull
	private boolean isGicik;
	
}

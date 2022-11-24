package com.turkcell.OBS.service.requests.create;

import javax.validation.constraints.NotNull;

import com.turkcell.OBS.model.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectRequest {

	@NotNull
	private String subjectName;
	
	public Subject toSubject() {
		Subject subject=new Subject();
		subject.setSubjectName(this.subjectName);
		return subject;
	}
}

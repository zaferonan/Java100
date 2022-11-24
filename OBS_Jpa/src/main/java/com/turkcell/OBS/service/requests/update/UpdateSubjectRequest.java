package com.turkcell.OBS.service.requests.update;

import javax.validation.constraints.NotNull;

import com.turkcell.OBS.model.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubjectRequest {

	@NotNull	
	private long subjectId;
	
	@NotNull
	private String subjectName;
	
	public Subject toSubject() {
		Subject subject=new Subject();
		subject.setSubjectId(subjectId);
		subject.setSubjectName(this.subjectName);
		return subject;
	}
}

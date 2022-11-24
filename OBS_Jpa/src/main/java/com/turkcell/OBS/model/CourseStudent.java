package com.turkcell.OBS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_student")
public class CourseStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseStudent_id")
	private long courseStudentId;
	@Column(name = "absence")
	private int courseStudentAbsence;
	@Column(name = "note")
	private long courseStudentNote;
	@ManyToOne()
	@JoinColumn(name = "course_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Course course;
	@ManyToOne()
	@JoinColumn(name = "student_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Student student;
}

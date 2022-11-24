package com.turkcell.OBS.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private long courseId;
	
	@ManyToOne()
	@JoinColumn(name = "subject_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Subject subject;
	
	@ManyToOne()
	@JoinColumn(name = "teacher_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Teacher teacher;
	
	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<CourseStudent> courseStudents;
	
}

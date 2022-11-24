package com.turkcell.OBS.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private long studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_number",unique = true,nullable = false)
	private long studentNumber;
	@Column(name = "student_year")
	private int studentYear;
	@OneToMany(mappedBy = "student")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<CourseStudent> courseStudents;
	
}

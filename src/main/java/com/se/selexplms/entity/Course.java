package com.se.selexplms.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int id;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_duration")
	private String courseDuration;
	
	@ManyToOne
	@JoinColumn(name = "instructor_id",referencedColumnName = "instructor_id")
	private Instructor instructor;
	
	@OneToMany(mappedBy = "course")
	private List<Lession> lessions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}



	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				 + ", instructor=" + instructor + "]";
	}

	public List<Lession> getLessions() {
		return lessions;
	}

	public void setLessions(List<Lession> lessions) {
		this.lessions = lessions;
	}
	
	
}

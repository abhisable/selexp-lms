package com.se.selexplms.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructors")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private int id;
	
	@Column(name="instructor_name")
	private String name;
	
	@Column(name="instructor_exp")
	private int instructorExp;
	
	@Column(name="instructor_email")
	private String email;
	
	@OneToMany(mappedBy = "instructor")
	private List<Course> courses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInstructorExp() {
		return instructorExp;
	}
	public void setInstructorExp(int instructorExp) {
		this.instructorExp = instructorExp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", instructorExp=" + instructorExp + ", email=" + email
				+ "]";
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
}

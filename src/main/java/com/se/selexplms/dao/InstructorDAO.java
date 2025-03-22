package com.se.selexplms.dao;

import java.util.List;

import com.se.selexplms.entity.Instructor;

public interface InstructorDAO {
	
	public List<Instructor> getAllInstructor();

	void addInstructor(Instructor instructor);

	public Instructor getInstructorById(int id);

	public void deleteInstructor(int id);



}

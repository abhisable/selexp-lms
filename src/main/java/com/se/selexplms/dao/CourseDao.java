package com.se.selexplms.dao;

import com.se.selexplms.entity.Course;
import com.se.selexplms.entity.Lession;

public interface CourseDao {

	public Course getCourse(int courseId);

	public Lession getLessionById(int lessionId);

	public void saveCourse(Course course);

}

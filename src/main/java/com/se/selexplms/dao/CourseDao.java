package com.se.selexplms.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.selexplms.entity.Course;

import jakarta.transaction.Transactional;

@Repository
public class CourseDao {

	@Autowired
	SessionFactory factory;
	
	@Transactional
	public Course getCourse(int courseId) {
		Session session = factory.getCurrentSession();
		Course course = session.get(Course.class, courseId);
		Hibernate.initialize(course.getLessions());
		return course;
		
	}
	
	

}

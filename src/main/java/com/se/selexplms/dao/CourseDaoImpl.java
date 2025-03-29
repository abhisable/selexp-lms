package com.se.selexplms.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.selexplms.entity.Course;
import com.se.selexplms.entity.Lession;

import jakarta.transaction.Transactional;

@Repository
public class CourseDaoImpl implements CourseDao{

	@Autowired
	SessionFactory factory;
	
	@Transactional
	public Course getCourse(int courseId) {
		Session session = factory.getCurrentSession();
		Course course = session.get(Course.class, courseId);
		Hibernate.initialize(course.getLessions());
		return course;
		
	}

	@Transactional
	public Lession getLessionById(int lessionId) {
		Session session = factory.getCurrentSession();
		Lession lession=session.get(Lession.class, lessionId);
		return lession;
	}
	
	

}

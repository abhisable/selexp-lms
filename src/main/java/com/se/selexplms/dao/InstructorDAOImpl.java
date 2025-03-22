package com.se.selexplms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.se.selexplms.entity.Instructor;

import jakarta.transaction.Transactional;

@Component
public class InstructorDAOImpl implements InstructorDAO {

	@Autowired
	SessionFactory factory;

	@Override
	@Transactional
	public List<Instructor> getAllInstructor() {
		Session session = factory.getCurrentSession();

		org.hibernate.query.Query<Instructor> query = session.createQuery("from Instructor", Instructor.class);

		List<Instructor> resultList = query.list();
		System.out.println(resultList);
		return resultList;
	}

	@Override
	@Transactional
	public void addInstructor(Instructor instructor) {
		Session session = factory.getCurrentSession();
		session.persist(instructor);

	}

	@Override
	@Transactional
	public Instructor getInstructorById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructor(int id) {
		Session session = factory.getCurrentSession();
		Instructor instructor=session.get(Instructor.class, id);
	    session.remove(instructor);
		
	}

}

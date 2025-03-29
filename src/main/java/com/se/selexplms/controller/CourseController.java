package com.se.selexplms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.se.selexplms.dao.CourseDao;
import com.se.selexplms.entity.Course;

@Controller
public class CourseController{
	@Autowired
	CourseDao dao;
	
	@GetMapping("show/{id}")
	public String showLessions(@PathVariable("id") int courseId, Model model) {
		Course course = dao.getCourse(courseId);
		model.addAttribute("course", course);
		return "lession-page";
		
	}
	
}
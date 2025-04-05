package com.se.selexplms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mchange.lang.StringUtils;
import com.se.selexplms.dao.CourseDao;
import com.se.selexplms.dao.InstructorDAO;
import com.se.selexplms.entity.Course;
import com.se.selexplms.entity.Lession;

@Controller
@SessionAttributes(names = {"min","max"})
public class CourseController{
	@Autowired
	CourseDao dao;
	
	@Autowired
	InstructorDAO insDao;
	
	@GetMapping("show/{id}")
	public String showLessions(@PathVariable("id") int courseId, Model model) {
		Course course = dao.getCourse(courseId);
		model.addAttribute("course", course);
		List<Lession> lessions=course.getLessions();
		int min=0;
		if(lessions!=null && lessions.size()>0)
		 min=lessions.get(0).getLessionId();
		model.addAttribute("min",min);
		model.addAttribute("max", min+lessions.size()-1);
		return "lession-page";
		
		
	}
	
	@GetMapping("lession")
	public String viewLession(@RequestParam("id") int lessionId, Model model) {
		Lession lession = dao.getLessionById(lessionId);
		model.addAttribute("lession", lession);
		return "lession-view-page";
		
	}
	
	@GetMapping("addCourse")
	public String addCourse(Course course,Model model) {
		
		model.addAttribute("course", course);
		model.addAttribute("allInstructors",insDao.getAllInstructor());
		return "add-course-page";
		
	}
	
	@PostMapping("saveCourse")
	public String saveCourse(Course course,Model model) {
		dao.saveCourse(course);
		String url=String.format("show/%d", course.getId());
		return "redirect:/"+url;
		
	}
}
package com.se.selexplms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.selexplms.dao.InstructorDAO;
import com.se.selexplms.entity.Instructor;

@Controller
public class LMSController {

	@Autowired
	InstructorDAO insDao;

	@RequestMapping("/getInstructors")
	public String getInstructors(Model model) {
		List<Instructor> allInstructor = insDao.getAllInstructor();
		model.addAttribute("instructorList", allInstructor);
		return "instructor-home";
	}

	@RequestMapping("/addInstructorPage")
	public String addInstructor(Model model) {
		model.addAttribute("instructor", new Instructor());
		return "add-instructor-page";
	}

	@RequestMapping("/addInstructor")
	public String addInstructor(Instructor instructor) {
		insDao.addInstructor(instructor);
		System.out.println(instructor);
		return "redirect:getInstructors";
	}

	@RequestMapping("/search")
	public String getInstructor(@RequestParam("id") int id, Model model) {

		Instructor instructor = insDao.getInstructorById(id);
		List<Instructor> allInstructor = new ArrayList<>();
		allInstructor.add(instructor);
		model.addAttribute("instructorList", allInstructor);
		return "instructor-home";
	}

	@RequestMapping("/delete/{id}")
	public String getInstructor(@PathVariable("id") int id) {

		insDao.deleteInstructor(id);
		return "redirect:/getInstructors";
	}

}

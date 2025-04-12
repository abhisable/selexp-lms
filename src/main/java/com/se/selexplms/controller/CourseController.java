package com.se.selexplms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mchange.lang.StringUtils;
import com.se.selexplms.dao.CourseDao;
import com.se.selexplms.dao.InstructorDAO;
import com.se.selexplms.entity.Course;
import com.se.selexplms.entity.Lession;
import com.se.selexplms.service.CourseService;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes(names = {"min","max"})
public class CourseController{
	@Autowired
	CourseDao dao;
	
	@Autowired
	InstructorDAO insDao;
	
	@Autowired
	CourseService service;
	
	@GetMapping("show/{id}")
	public String showLessions(@PathVariable("id") int courseId,@RequestParam(name = "pageNum",required = false,defaultValue = "0") String pageNum, Model model,HttpServletRequest request) {
		
		PagedListHolder<Lession> pagedLessionListHolder=(PagedListHolder<Lession>) request.getSession().getAttribute("pagedLessionListHolder");
		
		if(pagedLessionListHolder==null) {
		pagedLessionListHolder=new PagedListHolder<>();
		Course course = dao.getCourse(courseId);
		model.addAttribute("course", course);
		List<Lession> lessions=course.getLessions();
		pagedLessionListHolder.setSource(lessions);
		pagedLessionListHolder.setPageSize(3);
		
		
		if(pageNum.equals("prev")) {
			pagedLessionListHolder.previousPage();
		}
		else if(pageNum.equals("next"))
		{
			pagedLessionListHolder.nextPage();
		}
		else {
			pagedLessionListHolder.setPage(Integer.parseInt(pageNum));
		}
		request.getSession().setAttribute("pagedLessionListHolder", pagedLessionListHolder);
		request.getSession().setAttribute("course", course);
		int min=0;
		if(lessions!=null && lessions.size()>0)
		 min=lessions.get(0).getLessionId();
		model.addAttribute("min",min);
		model.addAttribute("max", min+lessions.size()-1);
		
		}
		else {
			if(pageNum.equals("prev")) {
				pagedLessionListHolder.previousPage();
			}
			else if(pageNum.equals("next"))
			{
				pagedLessionListHolder.nextPage();
			}
			else {
				pagedLessionListHolder.setPage(Integer.parseInt(pageNum));
			}
			
		}
		
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
	
	@ResponseBody
	@GetMapping("test")
	public String test(@RequestParam("pageNum") int pageNum,HttpServletRequest request) {
		
		service.test(pageNum,request);
		return "testing";
		
	}
	
	@PostMapping("saveCourse")
	public String saveCourse(Course course,Model model) {
		dao.saveCourse(course);
		String url=String.format("show/%d", course.getId());
		return "redirect:/"+url;
		
	}
}
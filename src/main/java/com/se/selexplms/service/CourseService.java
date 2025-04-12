package com.se.selexplms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import com.se.selexplms.controller.CourseDao;
import com.se.selexplms.entity.Course;
import com.se.selexplms.entity.Lession;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CourseService {
	
	@Autowired
	CourseDao courseDao;

	public void test(int pageNum,HttpServletRequest request) {
		
       PagedListHolder<Lession> pagedListHolder=(PagedListHolder<Lession>) request.getSession().getAttribute("pagedListHolder");
       if(pagedListHolder==null) {
    	   pagedListHolder=new PagedListHolder<>();
    	   Course course = courseDao.getCourse(7);
    	   List<Lession> lessionList = course.getLessions();
    	   
    	   pagedListHolder.setSource(lessionList);  
    	   pagedListHolder.setPage(pageNum);
    	   pagedListHolder.setPageSize(2);
    	   
    	   List<Lession> pageList=pagedListHolder.getPageList();
    	   showList(pageList);
    	   request.getSession().setAttribute("pagedListHolder", pagedListHolder);
    	   
    	   
       }
       else {
    	   pagedListHolder.setPage(pageNum);
    	   showList(pagedListHolder.getPageList());
    	   
       }
       
		
	}

	private void showList(List<Lession> pageList) {
		pageList.forEach(System.out::println);

	}

}

package com.project.precize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.precize.dao.StudentDao;
import com.project.precize.model.Student;

@Controller
public class HomeController {

	@Autowired
	StudentDao studentDao;
	
	@RequestMapping("/")
	String initializeData() {
		return "index";
	}
	
	@PostMapping("/process")
	String processInput(@RequestParam("option") String option, Model model) {
		 if (option.equalsIgnoreCase("insert")) {
	            return "insert";
	        } else if (option.equalsIgnoreCase("view")) {
	            List<Student> student = studentDao.fetchDetailsFromDatabase();
	            model.addAttribute("StudentDetails",student);
	            return "viewDetails";
	        } else if (option.equalsIgnoreCase("rank")) {
	            return "rank";
	        } else if (option.equalsIgnoreCase("update")) {
	            return "update";
	        } else if (option.equalsIgnoreCase("delete")) {
	            return "delete";
	        }
		return "";
	}
	
	@PostMapping("/insertData")
	public String insertData(@ModelAttribute Student student, Model model) {
		boolean isDataInserted=studentDao.insertData(student);
		if (isDataInserted) {
	        model.addAttribute("message", "Data inserted successfully");
	    } else {
	        model.addAttribute("message", "Failed to insert data");
	    }
	    return "redirect:/";
	}
	
	@PostMapping("/findRank")
	public String findRankofStudent(@RequestParam("name") String studentName,Model model) {
		Student studentDetails=studentDao.findRankofStudent(studentName);
		model.addAttribute("rankdetails", studentDetails);
		return "displayStudent";
	}
}

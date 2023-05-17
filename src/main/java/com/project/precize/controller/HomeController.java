package com.project.precize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			model.addAttribute("StudentDetails", student);
			return "viewDetails";
		} else if (option.equalsIgnoreCase("rank")) {
			return "rank";
		} else if (option.equalsIgnoreCase("update")) {
			return "update";
		} else if (option.equalsIgnoreCase("delete")) {
			return "deleteStudent";
		}
		return "";
	}

	@PostMapping("/insertData")
	public String insertData(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
		boolean isDataInserted = studentDao.insertData(student);
		if (isDataInserted) {
			redirectAttributes.addAttribute("message", "Data inserted successfully");
		} else {
			redirectAttributes.addAttribute("message", "Failed to insert data");
		}

		return "redirect:/";
	}

	@PostMapping("/findRank")
	public String findRankofStudent(@RequestParam("name") String studentName, Model model) {
		Student studentDetails = studentDao.findRankofStudent(studentName);
		model.addAttribute("rankdetails", studentDetails);
		return "displayStudent";
	}

	@PostMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("name") String studentName, RedirectAttributes redirectAttributes) {
		boolean isStudentDeleted = studentDao.deleteStudent(studentName);
		if (isStudentDeleted) {
			redirectAttributes.addAttribute("message", "Data deleted successfully");
		} else {
			redirectAttributes.addAttribute("message", "Failed to delete data");
		}
		
		return "redirect:/";
	}
	
	@PostMapping("getUserDetailsforUpdate")
	public String getUserDetailsforUpdateProcess(@RequestParam("name") String studentName, Model model) {
		Student student=studentDao.findStudentByName(studentName);
		model.addAttribute("studentDetailsForUpdate", student);
		return "updateSATScore";
	}
	
	@PostMapping("updateData")
	public String updateExistingRecord(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
		boolean isStudentUpdated=studentDao.updateExistingRecord(student);
		if (isStudentUpdated) {
			redirectAttributes.addAttribute("message", "Data updated successfully");
		} else {
			redirectAttributes.addAttribute("message", "Failed to update data");
		}
		
		return "redirect:/";
	}
	
	
}

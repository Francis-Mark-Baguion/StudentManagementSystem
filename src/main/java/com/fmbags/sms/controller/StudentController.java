package com.fmbags.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fmbags.sms.entity.Student;
import com.fmbags.sms.service.StudentService;
import com.fmbags.sms.service.impl.StudentServiceImpl;

@Controller

public class StudentController {

	private StudentServiceImpl studentService;

	public StudentController(StudentServiceImpl studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listOfStudents(Model model) {
		model.addAttribute("students", studentService.listOfStudents());
		return "students";
	}
	
}

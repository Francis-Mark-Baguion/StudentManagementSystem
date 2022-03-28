package com.fmbags.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/students/new")
	public String addNewStudentForm(Model model) {
		
		//create student object to whole student form
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student){
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updatStudenty(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
}

package com.fmbags.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmbags.sms.entity.Student;
import com.fmbags.sms.repository.StudentRepo;
import com.fmbags.sms.service.StudentService;

@Service
public class StudentServiceImpl{
	
	private StudentRepo studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}



	public List<Student> listOfStudents(){
		return studentRepo.findAll();
	}
}

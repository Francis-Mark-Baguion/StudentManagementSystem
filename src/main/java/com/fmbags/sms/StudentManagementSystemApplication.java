package com.fmbags.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fmbags.sms.entity.Student;
import com.fmbags.sms.repository.StudentRepo;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepo studentRepo;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("francis","mark","baguion445@gmail.com");
		studentRepo.save(student1);
		
	}

}

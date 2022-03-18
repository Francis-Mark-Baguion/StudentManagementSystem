package com.fmbags.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fmbags.sms.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}

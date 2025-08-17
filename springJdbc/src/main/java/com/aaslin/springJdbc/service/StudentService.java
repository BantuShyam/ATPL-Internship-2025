package com.aaslin.springJdbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaslin.springJdbc.dao.StudentDAO;
import com.aaslin.springJdbc.model.Student;

@Service
public class StudentService {

	private final StudentDAO studentDAO;

	public StudentService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	public void addStudent(Student student) {
		studentDAO.insertStudents(student);
	}
	
	public List<Student> fetchStudents() {
		return studentDAO.getStudents();
	}

}

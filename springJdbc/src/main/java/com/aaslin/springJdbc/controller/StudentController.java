package com.aaslin.springJdbc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.springJdbc.model.Student;
import com.aaslin.springJdbc.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Student added successfully";
	}
	
	@GetMapping("/list")
	public List<Student> getStudent() {
		return studentService.fetchStudents();
	}
}

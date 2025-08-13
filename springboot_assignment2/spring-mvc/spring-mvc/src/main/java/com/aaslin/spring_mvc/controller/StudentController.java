package com.aaslin.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaslin.spring_mvc.entity.Student;
import com.aaslin.spring_mvc.exception.StudentNotFoundException;
import com.aaslin.spring_mvc.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "list-students";
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("student",new Student());
		return "student-form";
	}
	
	@PostMapping("/save")
	public String saveStudents(@Valid @ModelAttribute Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "student-form";
		}
		if(student.getId()==0) {
			studentService.addStudent(student);
		}
		else {
			studentService.updateStudent(student);
		}
		return "redirect:/students";
	}
	
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam("id") int id,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public String handleNotFound(StudentNotFoundException ex,Model model) {
		model.addAttribute("errorMessage",ex.getMessage());
		return "not-found";
	}
}

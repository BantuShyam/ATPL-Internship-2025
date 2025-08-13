package com.aaslin.spring_mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aaslin.spring_mvc.entity.Student;
import com.aaslin.spring_mvc.exception.StudentNotFoundException;

@Service
public class StudentService {
	private List<Student> students=new ArrayList<>();
	private int idCounter=1;
	
	public List<Student> getAllStudents(){
		return students;
	}
	
	public void addStudent(Student student) {
		student.setId(idCounter++);
		students.add(student);
	}
	public Student getStudentById(int id) {
		return students.stream()
				.filter(s->s.getId() ==id)
				.findFirst()
				.orElseThrow(()-> new StudentNotFoundException("Student with id "+id+" not found"));
	}
	
	public void updateStudent(Student student) {
		Student existing=getStudentById(student.getId());
		existing.setName(student.getName());
		existing.setEmail(student.getEmail());
		existing.setCourse(student.getCourse());
	}
	
	public void deleteStudent(int id) {
		Student student=getStudentById(id);
		students.remove(id);
	}
}

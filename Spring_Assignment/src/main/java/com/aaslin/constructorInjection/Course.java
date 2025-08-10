package com.aaslin.constructorInjection;

public class Course {
private String courseName;
public Course(String courseName) {
	this.courseName=courseName;
	System.out.println("Course Name is "+courseName);
}
public String getCourseName() {
	return courseName;
}
}

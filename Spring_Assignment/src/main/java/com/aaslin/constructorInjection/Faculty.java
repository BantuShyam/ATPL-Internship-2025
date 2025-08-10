package com.aaslin.constructorInjection;

public class Faculty {
private Course course;

public Faculty(Course course) {
	super();
	this.course = course;
	System.out.println("Faculty created..");
}
public void showDetails() {
	System.out.println("Faculty assigned with "+course.getCourseName());
	
}


}

package com.aaslin.springPractice;


public class College {
	private Student student;
public College() {
	System.out.println("Inside college...");
}
public void setStudent(Student student) {
	this.student=student;	
   }
public void showCollege() {
	System.out.println("College has student: ");
	student.show();
}
//AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("beans.xml");
// student=context.getBean("student",Student.class);
// student.show();
}

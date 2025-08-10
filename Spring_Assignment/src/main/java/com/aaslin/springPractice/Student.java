package com.aaslin.springPractice;

public class Student {
	private String name;
	public Student() {
		System.out.println("Inside Student ");	
	}
	public void setName(String name) {
		this.name=name;
	}
	public void show() {
		System.out.println("Student name is : "+name);
	}

}

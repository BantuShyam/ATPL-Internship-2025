package com.aaslin.autoWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	private String ename;
	@Autowired
	private Department department;
	
	
	private Department deptSetter;
	private Department deptConstruct;
	
	@Autowired
	public void setDeptSetter(Department deptSetter) {
		this.deptSetter = deptSetter;
	}
	
	@Autowired
	public void setDeptConstruct(Department deptConstruct) {
		this.deptConstruct = deptConstruct;
	}
	
	
	public void showDetails() {
		System.out.println("Field Injection ");
		department.show();
		System.out.println("Setter Injection ");
		deptSetter.show();
		System.out.println("Constructor Injection ");
		deptConstruct.show();
		System.out.println("Employee is "+ename);

	}

	public Employee(String ename) {
		super();
		this.ename = ename;
	}
	
}

package com.aaslin.autoWiring;

import org.springframework.stereotype.Component;

@Component
public class Department {
	private String deptName;
	

	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	public void show() {
		System.out.println(" deptName: "+deptName);
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}

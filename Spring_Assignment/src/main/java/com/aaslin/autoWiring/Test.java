package com.aaslin.autoWiring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Test {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
		Employee employee=context.getBean(Employee.class);
		employee.showDetails();
	}
}

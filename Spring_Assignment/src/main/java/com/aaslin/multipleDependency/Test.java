package com.aaslin.multipleDependency;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] a) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		University universityDetails=(University) context.getBean("university");
		universityDetails.toString();
		context.close();
	}
}

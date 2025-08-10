package com.aaslin.constructorInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
public static void main(String[] args) {
	//XML based configuration
//	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//	Faculty faculty=context.getBean("facultyBean",Faculty.class);
//	faculty.showDetails();
//	context.close();
	
	//Java-based configuration
	AnnotationConfigApplicationContext annotationContext=new AnnotationConfigApplicationContext(AppConfig.class);
	Faculty fac=annotationContext.getBean(Faculty.class);
	fac.showDetails();
	annotationContext.close();
}
}

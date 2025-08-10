package com.aaslin.setterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("com.aaslin.setterInjection")
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//		Library library=(Library) context.getBean("library");
//		library.show();
		
		//Annotation based
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Main.class);
		Library library=context.getBean(Library.class);
		library.show();
	}

}

package com.aaslin.beanLifeCycle;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan("com.aaslin.beanLifeCycle")
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		context.close();
//		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//		Teacher teacher=context.getBean(Teacher.class);
//		context.close();
		
	}

}

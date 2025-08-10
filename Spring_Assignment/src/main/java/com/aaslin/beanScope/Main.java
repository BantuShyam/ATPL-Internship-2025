package com.aaslin.beanScope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;


@Configuration
public class Main {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
	
	System.out.println("Singleton");
	Laptop laptop=context.getBean(Laptop.class);
	System.out.println(laptop.hashCode());
	Laptop laptop1=context.getBean(Laptop.class);
	System.out.println(laptop1.hashCode());
	System.out.println("same object "+(laptop1==laptop));
	
	System.out.println("prototype");
	Speaker speaker=context.getBean(Speaker.class);
	System.out.println(speaker);
	System.out.println(speaker.hashCode());
	Speaker speaker1=context.getBean(Speaker.class);
	System.out.println(speaker1);
	System.out.println(speaker1.hashCode());
	System.out.println("same object "+(speaker1==speaker));
}
}

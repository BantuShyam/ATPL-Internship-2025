package com.aaslin.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] a) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		ServerConfig config=context.getBean(ServerConfig.class);
		config.printConfig();
	}
}

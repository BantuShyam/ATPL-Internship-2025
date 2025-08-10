package com.aaslin.autoWiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.aaslin.autoWiring")
public class AppConfig {
	@Bean
	public Department department() {
		return new Department("Computer science");
	}
	
	@Bean
	public Employee employee() {
		return new Employee("Kartheek ");
	}
}

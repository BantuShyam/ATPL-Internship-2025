package com.aaslin.constructorInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Course course() {
		return new Course("Spring boot ..");
	}
	
	@Bean
	public Faculty faculty() {
		return new Faculty(course());
	}
}

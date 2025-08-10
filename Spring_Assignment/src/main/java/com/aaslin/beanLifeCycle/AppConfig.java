package com.aaslin.beanLifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
public Teacher teacher() {
	return new Teacher();
	
}
}

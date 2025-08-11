package com.aaslin.Beans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aaslin.Beans.service.GreetingService;

@Configuration
public class AppConfig {

	@Bean
	public GreetingService greeting() {
		return new GreetingService();
	}
}

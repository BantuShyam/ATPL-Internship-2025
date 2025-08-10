package com.aaslin.value;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.aaslin.value")
@PropertySource("classpath:application.properties")
public class AppConfig {

}


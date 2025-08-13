package com.aaslin.DispatcherServlet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aaslin.DispatcherServlet.interceptor.FlowLoggingInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FlowLoggingInterceptor())
                .addPathPatterns("/**"); // apply to all URLs
    }
}

package com.aaslin.beanLifeCycle;

import org.springframework.stereotype.Component;


//Using interfaces
//public class Teacher implements InitializingBean,DisposableBean {
//	@Override
//	public void afterPropertiesSet() {
//		System.out.println("Teacher class is initialized...");
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Teacher class is destoryed...");
//	}

//}


//Using annotations
@Component
public class Teacher{
//	@PostConstruct
//	public void init() {
//		System.out.println("Teacher class is initialized...");
//	}
//	@PreDestroy
//	public void destroy() {
//		System.out.println("Teacher class is destroyed...");
//	}
	public void init() {
		System.out.println("Teacher bean is initialized using xml...");
	}
	public void destroy() {
		System.out.println("Teacher bean is destroyed using xml...");
	}
}

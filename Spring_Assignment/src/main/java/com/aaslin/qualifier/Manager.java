package com.aaslin.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Manager implements Leader {

	@Override
	public void lead() {
		System.out.println("Manager is leading the project..");
		
	}
	
}

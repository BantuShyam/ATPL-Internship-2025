package com.aaslin.qualifier;

import org.springframework.stereotype.Component;

@Component
public class TeamLead implements Leader {

	@Override
	public void lead() {
		System.out.println("Team Leader is leading the project..");
		
	}

}

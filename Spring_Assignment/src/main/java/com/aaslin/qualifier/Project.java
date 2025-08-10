package com.aaslin.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Project {
	@Autowired
	@Qualifier("teamLead")
	private Leader leader;
	public void start() {
		leader.lead();
	}
}

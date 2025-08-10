package com.aaslin.component;

import org.springframework.stereotype.Component;

@Component
public class Trainer {

    private String name = "Shyam";
    private String subject = "Spring";

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }
}


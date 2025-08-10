package com.aaslin.component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainingCenter {

    @Autowired
    private Trainer trainer;

    public void displayTrainerDetails() {
        System.out.println("Trainer Name: " + trainer.getName());
        System.out.println("Trainer Subject: " + trainer.getSubject());
    }
}

package com.aaslin.beanScope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") 
public class Laptop {

    @Value("HP")
    private String name;
    private final Speaker speaker;
    public Laptop(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "Laptop [name=" + name + ", speaker=" + speaker + "]";
    }
}

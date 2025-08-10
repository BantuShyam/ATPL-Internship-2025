package com.aaslin.beanScope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Speaker {

    @Value("Mivi")
    private String sname;

    @Override
    public String toString() {
        return "Speaker [sname=" + sname + "]";
    }
}

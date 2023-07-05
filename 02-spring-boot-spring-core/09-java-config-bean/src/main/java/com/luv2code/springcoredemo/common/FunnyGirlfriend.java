package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



@Component
public class FunnyGirlfriend implements Girlfriend {
    public FunnyGirlfriend() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String GetName() {
        return "Funny sophia >:-D";
    }

}

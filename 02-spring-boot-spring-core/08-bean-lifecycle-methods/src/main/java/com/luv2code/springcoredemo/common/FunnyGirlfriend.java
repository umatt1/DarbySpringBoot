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

    @PostConstruct
    public void PostConstruct (){
        System.out.println("In PostConstruct for " + getClass().getSimpleName());
    }

    @PreDestroy
    public void PreDestroy() {
        System.out.println("In PreDestroy for " + getClass().getSimpleName());
    }

}

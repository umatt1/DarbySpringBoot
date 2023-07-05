package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FunnyGirlfriend implements Girlfriend {
    public FunnyGirlfriend() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String GetName() {
        return "Funny sophia >:-D";
    }
}

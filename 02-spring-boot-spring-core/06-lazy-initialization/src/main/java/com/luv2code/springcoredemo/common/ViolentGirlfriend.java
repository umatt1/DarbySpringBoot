package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class ViolentGirlfriend implements Girlfriend{
    public ViolentGirlfriend() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String GetName() {
        return "Violent sophia 👊😈";
    }
}

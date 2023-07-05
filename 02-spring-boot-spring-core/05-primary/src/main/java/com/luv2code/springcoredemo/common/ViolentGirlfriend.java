package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class ViolentGirlfriend implements Girlfriend{
    @Override
    public String GetName() {
        return "Violent sophia 👊😈";
    }
}

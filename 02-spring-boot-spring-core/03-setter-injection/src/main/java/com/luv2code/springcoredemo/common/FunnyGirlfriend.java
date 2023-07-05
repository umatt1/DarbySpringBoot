package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FunnyGirlfriend implements Girlfriend {
    @Override
    public String GetName() {
        return "Funny sophia >:-D";
    }
}

package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FunnyGirlfriend implements Girlfriend {
    @Override
    public String GetName() {
        return "Funny sophia >:-D";
    }
}

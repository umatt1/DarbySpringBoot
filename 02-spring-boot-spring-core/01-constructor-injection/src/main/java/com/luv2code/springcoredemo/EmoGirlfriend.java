package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class EmoGirlfriend implements Girlfriend {
    @Override
    public String GetName() {
        return "Emo Sophia";
    }
}

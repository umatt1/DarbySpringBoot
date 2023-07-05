package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class EmoGirlfriend implements Girlfriend {
    public EmoGirlfriend() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String GetName() {
        return "Emo Sophia o_o";
    }
}

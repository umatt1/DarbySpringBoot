package com.luv2code.springcoredemo.common;

public class TiredGirlfriend implements Girlfriend{
    public TiredGirlfriend() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String GetName() {
        return "zzzzzzzzzophia 😴";
    }
}

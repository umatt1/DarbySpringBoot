package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FunnyGirlfriend implements Girlfriend {
    public FunnyGirlfriend() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String GetName() {
        return "Funny sophia >:-D";
    }
}

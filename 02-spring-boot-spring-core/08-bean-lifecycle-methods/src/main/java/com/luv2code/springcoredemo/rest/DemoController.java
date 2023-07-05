package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Girlfriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Girlfriend epicGirlfriend;

    @Autowired // optional if only one constructor
    public DemoController(@Qualifier("funnyGirlfriend") Girlfriend girl) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        epicGirlfriend = girl;
    }

    @GetMapping("/name")
    public String getName() {
        return epicGirlfriend.GetName();
    }

}

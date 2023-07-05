package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Girlfriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Girlfriend epicGirlfriend;
    private Girlfriend secondGirlfriend;

    @Autowired // optional if only one constructor
    public DemoController(@Qualifier("funnyGirlfriend") Girlfriend girl,
                          @Qualifier("funnyGirlfriend") Girlfriend otherGirl) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        epicGirlfriend = girl;
        secondGirlfriend = otherGirl;
    }

    @GetMapping("/name")
    public String getName() {
        return epicGirlfriend.GetName();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing girlfriends, are the same?: " + (epicGirlfriend == secondGirlfriend);
    }
}

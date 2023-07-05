package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Girlfriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Girlfriend epicGirlfriend;

    /*
    This is a constructor injection.
    It is recommended with required dependencies
    Spring.io development team recommends as first choice
     */
/*    @Autowired // optional if only one constructor
    public DemoController(@Qualifier("funnyGirlfriend") Girlfriend girl) {
        epicGirlfriend = girl;
    }*/

    /*
    This is a setter injection.
    Recommended with optional dependencies
    If dependency not provided, can then use
        reasonable default logic
     */
    @Autowired
    public void setGirlfriend(Girlfriend newGirl) {
        epicGirlfriend = newGirl;
    }

    @GetMapping("/name")
    public String GetName() {
        return epicGirlfriend.GetName();
    }
}

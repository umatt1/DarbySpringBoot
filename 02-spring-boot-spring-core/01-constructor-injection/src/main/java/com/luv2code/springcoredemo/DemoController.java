package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Girlfriend epicGirlfriend;

    @Autowired // optional if only one constructor
    public DemoController(Girlfriend girl) {
        epicGirlfriend = girl;
    }

    @GetMapping("/name")
    public String GetName() {
        return epicGirlfriend.GetName();
    }
}

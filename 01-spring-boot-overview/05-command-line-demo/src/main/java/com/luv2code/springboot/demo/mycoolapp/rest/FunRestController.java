package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${girlfriend.name}")
    private String girlfriend;

    @GetMapping("/")
    public String sayHello() {
        return String.format("Hello %s!", girlfriend);
    }

    // expose a new endpoint
    @GetMapping("/epic")
    public String epicGirlfriend() {
        return String.format("%s is epic!", girlfriend);
    }

    @GetMapping("/fortune")
    public String girlfriendFortune() {
        return String.format("It is %s's lucky day!", girlfriend);
    }

}

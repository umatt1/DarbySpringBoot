package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Girlfriend;
import com.luv2code.springcoredemo.common.TiredGirlfriend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GirlfriendConfig {

    @Bean("sleepy")
    public Girlfriend tiredGirlfriend() { // beanid defaults to method name
        return new TiredGirlfriend();
    }
}

package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails Matthew = User.builder()
                .username("matthew")
                .password("{noop}sophia")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        UserDetails Sophia = User.builder()
                .username("sophia")
                .password("{noop}sophia")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails Erick = User.builder()
                .username("erick")
                .password("{noop}sophia")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(Matthew, Sophia, Erick);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use basic auth
        http.httpBasic(Customizer.withDefaults());

        // disable CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

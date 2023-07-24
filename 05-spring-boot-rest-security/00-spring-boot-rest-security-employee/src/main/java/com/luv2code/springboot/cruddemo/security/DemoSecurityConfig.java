package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for jdbc
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // define query for user
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select * from members where user_id=?"
        );
        // define query for role
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select * from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
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

    /*
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
     */



}

package com.gateway.bank;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // All request to client microservice must be authenticated
                .antMatchers("/client-microservice/**")
                .authenticated()
                // All other request can be unauthenticated
                .anyRequest()
                .permitAll();
    }

}
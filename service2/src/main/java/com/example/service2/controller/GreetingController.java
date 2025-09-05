package com.example.service2.controller;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/service2/greet")
    public String greet(@AuthenticationPrincipal Jwt jwt) {
        return "Greetings " + jwt.getSubject() + " from Service 2";
    }
}

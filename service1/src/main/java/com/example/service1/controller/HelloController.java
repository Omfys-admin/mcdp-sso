package com.example.service1.controller;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/service1/hello")
    public String hello(@AuthenticationPrincipal Jwt jwt) {
        return "Hello " + jwt.getSubject() + " from Service 1";
    }
}

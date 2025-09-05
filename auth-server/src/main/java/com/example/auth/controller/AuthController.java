package com.example.auth.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SecretKey key = Keys.hmacShaKeyFor("mysecretmysecretmysecretmysec".getBytes());

    @PostMapping("/token")
    public String token(Authentication authentication) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("authorities", authentication.getAuthorities())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30, ChronoUnit.MINUTES)))
                .signWith(key)
                .compact();
    }
}

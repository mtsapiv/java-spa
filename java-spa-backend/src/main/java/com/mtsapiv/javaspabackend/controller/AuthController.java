package com.mtsapiv.javaspabackend.controller;

import com.mtsapiv.javaspabackend.configuration.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    private final SecurityProperties securityProperties;

    @Autowired
    public AuthController(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @GetMapping("login")
    public ResponseEntity login() {
        return new ResponseEntity(HttpStatus.OK);
    }
}

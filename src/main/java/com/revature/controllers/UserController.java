package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("This is a user of the ERSA System");
    }
}

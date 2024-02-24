package com.example.demo.controllers;

import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
public class UserController {

    @RequestMapping("/login")
    public boolean login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.isAuthenticated();
    }


    @RequestMapping("/user")
    public ResponseEntity<Map<String, String>> user() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();

    Map<String, String> userInfo = new HashMap<>();
    userInfo.put("username", username);

    return ResponseEntity.ok(userInfo);
}
}
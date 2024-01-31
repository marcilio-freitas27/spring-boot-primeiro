package com.example.demo.controllers;

import java.security.Principal;
import java.util.Base64;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
public class UserController {

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
          user.getName().equals("user") && user.getPassword().equals("password");
    }

    // @RequestMapping("/logout")
    // public boolean logout(@RequestBody User user) {
    //     return
    //       false;
    // }

    
    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
          .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
          .decode(authToken)).split(":")[0];
    }
}
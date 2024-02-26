package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.Login;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login entity) {
        if("usuario".equals(entity.getUsername()) && "123456".equals(entity.getPassword())) {
            return ResponseEntity.ok("Seja bem vindo, " + entity.getUsername());
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha ou usuário inválidos");
        }
        
    }
    
}

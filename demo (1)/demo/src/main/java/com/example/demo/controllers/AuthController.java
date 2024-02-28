package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private final BCryptPasswordEncoder passEncoder;

    public AuthController(BCryptPasswordEncoder passEncoder) {
        this.passEncoder = passEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login entity) {
        String user = entity.getUsername();
        String pass = entity.getPassword();
        String hashedPassword = passEncoder.encode(pass);

        if("usuario".equals(user) && passEncoder.matches("123456", hashedPassword)) {
            String usernameCapitalize = user.substring(0, 1).toUpperCase() + user.substring(1);
            return ResponseEntity.ok("Seja bem vindo, " + usernameCapitalize);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha ou usuário inválidos");
        }
        
    }
    
}

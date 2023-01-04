package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Primeiro web service
//Mavem - Controlador de dependências 
//pom.xml - onde estão as dependencias do projeto
@RestController
//@Controller
public class PrimeiroController {

    //primeiras rotas
    @GetMapping(path = "/")
    public String oi(){
        return "Oi";
    }

    @GetMapping(path = { "/eai", "/fala" })
    public String eai(){
        return "E aí!";
    }

    // nao pode ter a mesma rota, url para o msmo metodo
    @RequestMapping(method = RequestMethod.GET, path = "/saudacao")
    public String saudacao(){
        return "Olá Spring Boot";
    }

}

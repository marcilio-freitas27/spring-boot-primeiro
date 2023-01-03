package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Primeiro web service
//Mavem - Controlador de dependências 
//pom.xml - onde estão as dependencias do projeto
@RestController
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

    @RequestMapping(method = RequestMethod.GET, path = "/ola")
    public String ola(){
        return "Olá Spring Boot";
    }
}

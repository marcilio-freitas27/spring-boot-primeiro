package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping
    public String inicio(){
        String linha = "Bem-vindo a <b>Spring Calculator</b> ";
        linha += "<br> <a type='button' href='/calculadora/somar/10/20'>Somar</a>";
        linha += "<br> <a type='button' href='/calculadora/subtrair?a=10&b=20'>Subtrair</a>";
        linha += "<br> <a type='button' href='/calculadora/multiplicar/10/20'>Multiplicar</a>";
        linha += "<br> <a type='button' href='/calculadora/dividir?a=10&b=20'>Dividir</a><br>";
        return linha;
    }
    
    @GetMapping("/somar/{primeiro}/{segundo}")
    public int somar(@PathVariable int primeiro,@PathVariable int segundo){
        return primeiro + segundo;
    }

    @GetMapping("/subtrair")
    public int subtrair(@RequestParam int a, @RequestParam int b){
        return a - b;
    }

    @GetMapping("/multiplicar/{primeiro}/{segundo}")
    public int multiplicar(@PathVariable int primeiro, @PathVariable int segundo){
        return primeiro * segundo;
    }

    @GetMapping("/dividir")
    public int dividir(@RequestParam int a, @RequestParam int b){
        return a / b;
    }

}
// $ git commit -m "Criando o controller calculadora e seu métodos com get: Desafio."

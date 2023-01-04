package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Cliente;

@RestController
@RequestMapping("/clientes")
// rota principal
public class ClienteController {
    
    @GetMapping("/qualquer")
    // rota secundaria a principal
    public Cliente obterCliente(){
        return new Cliente(32, "Marcilio", "000.001.002-03");
    }

    @RequestMapping(path = "/json")
    public String json(){
        String json = "{\"id\": \"1\",\"nome\": \"Marcilio\",\"cpf\": \"001.002.003-04\"}";
        return json;
    }

    @RequestMapping(path = "/lista")
    public String[] lista(){
        String[] lista = {"1", "Marcilio", "001.002.003-04" };
        return lista;
    }

    @GetMapping("/{id}")
    public Cliente getClienteId(@PathVariable int id){
        return new Cliente(id, "Maria", "001.002.003-04");
    }

    @GetMapping
    public Cliente getClienteById(
        @RequestParam(name = "id", defaultValue = "1") int id){
        return new Cliente(id, "Fulano", "111.222.333-44");
    }

}
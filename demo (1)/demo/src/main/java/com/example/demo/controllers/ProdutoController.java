package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.Produto;
import com.example.demo.models.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    // @Autowired
    // private ProdutoRepository produtoRepository;

    @GetMapping
    public Produto getProdutos(){
        return new Produto(1, "Café Santa Clara");
    }

    @PostMapping
    public @ResponseBody Produto novoProduto(@RequestParam String nome){
        // rsponse body deixa claro que é um resposta com body
        Produto produto = new Produto(nome);
        // produtoRepository.save(produto);
        return produto;
    }

}

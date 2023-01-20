package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.Produto;
import com.example.demo.models.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    //cria um objeto automaticamente
    private ProdutoRepository produtoRepository;

    @GetMapping("/teste")
    public Produto getProdutos(){
        return new Produto("Café Santa Clara", 200.00, 0.15);
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProduto(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    @GetMapping
    public Iterable<Produto> obterProdutos(){
        return produtoRepository.findAll();
    }

    @PostMapping(path = "/produtos")
    public @ResponseBody Produto novoProduto(
        @RequestParam String nome, 
        @RequestParam double preco,
        @RequestParam double desconto
     ){
        // rsponse body deixa claro que é um resposta com body
        Produto produto = new Produto(nome, preco, desconto);
        produtoRepository.save(produto);
        return produto;
    }

    @PutMapping("/produtos")
    public Produto alterarProduto(@Validated Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }

}

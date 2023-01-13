package com.example.demo.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// obrigatoria
public class Produto {
    
    @Id
    // obrigatoria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // estrategia de sequencia de id única
    private int id;
    private String nome;
    private double preco;
    private double desconto;

    public Produto() {
    }

    public Produto(int id) {
        this.id = id;
    }

    public Produto(String nome, double preco, double desconto) {
        // adicionando novos campos o jpa faz um alter table auto
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}

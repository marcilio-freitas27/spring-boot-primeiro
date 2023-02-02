package com.example.demo.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//validations
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
// obrigatoria
public class Produto {
    
    @Id
    // obrigatoria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // estrategia de sequencia de id única
    private int id;

    //validações
    @NotBlank
    private String nome;

    @Min(0)
    private double preco;

    @Min(0)
    @Max(1)
    private double desconto;

    public Produto() {
    }

    public Produto(int id) {
        this.id = id;
    }

    public Produto(String nome, double preco, double desconto) {
        // adicionando novos campos o jpa faz um alter table auto
        super();
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

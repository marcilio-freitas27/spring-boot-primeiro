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

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

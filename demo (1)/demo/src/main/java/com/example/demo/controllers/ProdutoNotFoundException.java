package com.example.demo.controllers;

public class ProdutoNotFoundException extends RuntimeException {
    // classe para tratamento de erro
    public ProdutoNotFoundException(String message) {
        super(message);
    }
}
package com.example.demo.sql;

public interface ProdutoQueries {

    String APLICAR_DESCONTO = "Select (p.preco * p.desconto) FROM Produto p";
}

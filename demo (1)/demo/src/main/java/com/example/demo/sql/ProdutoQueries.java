package com.example.demo.sql;

public interface ProdutoQueries {

    String APLICAR_DESCONTO = "SELECT (p.preco * p.desconto) FROM Produto p";
    String MEDIA_PRECOS = "SELECT nome, preco, (SELECT AVG(preco) from Produto) media_precos FROM Produto";
}

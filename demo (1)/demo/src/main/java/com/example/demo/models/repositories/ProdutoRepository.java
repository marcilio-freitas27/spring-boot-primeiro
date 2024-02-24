package com.example.demo.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.entities.Produto;
import com.example.demo.sql.ProdutoQueries;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    //generics <Produto, id>
    // repository é uma classe que fornecesse acesso aos dados de uma entidade de um banco de dados

    // O spring cria automaticamente seguindo as convenções
    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

    @Query("SELECT p FROM Produto p Where p.nome LIKE %:nome%")
    public Iterable<Produto> searchBynameLike(@Param("nome") String nome);

    @Query("SELECT SUM(p.preco) FROM Produto p")
    public Double getTotal();

    @Query("SELECT AVG(p.preco) FROM Produto p")
    public Double getAverage();
    
    @Query(value = ProdutoQueries.APLICAR_DESCONTO)
    List<Double> applyOffer();
}




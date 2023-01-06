package com.example.demo.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entities.Produto;

public class ProdutoRepository extends CrudRepository<Produto, Integer>{
    //generics <Produto, id>
    
}

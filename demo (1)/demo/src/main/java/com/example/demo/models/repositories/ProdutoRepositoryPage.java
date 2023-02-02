package com.example.demo.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.entities.Produto;

public interface ProdutoRepositoryPage extends PagingAndSortingRepository<Produto, Integer>{
    //generics <Produto, id>
}
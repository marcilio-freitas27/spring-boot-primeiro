package com.example.demo.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}

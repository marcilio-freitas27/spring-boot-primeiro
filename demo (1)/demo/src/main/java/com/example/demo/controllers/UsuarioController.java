
package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.Usuario;
import com.example.demo.models.repositories.UsuarioRepository;

import jakarta.validation.Valid;


@RestController()
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping()
    public Iterable<Usuario> getUsuario(){
        return usuarioRepository.findAll();
    }

    @PostMapping()
    public @ResponseBody Usuario postUsuario(
        @RequestParam String nomeCompleto, 
        @RequestParam boolean ativo
        ){
        Usuario usuario = new Usuario(nomeCompleto, ativo); 
        usuarioRepository.save(usuario);
        return usuario;
    }

    @PutMapping()
    public Usuario putUsuario(@Validated Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    @DeleteMapping("/codigo")
    public void deleteUsuario(@PathVariable int codigo){
        usuarioRepository.deleteById(codigo);
    }
}

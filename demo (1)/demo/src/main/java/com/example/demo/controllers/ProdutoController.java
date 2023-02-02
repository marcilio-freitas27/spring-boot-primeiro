package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.Produto;
import com.example.demo.models.repositories.ProdutoRepository;
import com.example.demo.models.repositories.ProdutoRepositoryPage;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    //cria um objeto automaticamente
    private ProdutoRepository produtoRepository;
    private ProdutoRepositoryPage produtoRepositoryPage;

    @GetMapping("/teste")
    public Produto getProdutos(){
        return new Produto("Café Santa Clara", 200.00, 0.15);
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProduto(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    @GetMapping
    public Iterable<Produto> obterProdutos(){
        //Semelhante ao Generics que o angular usa nos servicos
        return produtoRepository.findAll();
    }


    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
        
        // consulta por nome - criada em produto repository
        // feito em convenção
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    @GetMapping(path = "/nomeQuery/{parteNome}")
    public Iterable<Produto> obterProdutosPorNomeQuery(@PathVariable String parteNome) {

        // consulta por nome - criada em produto repository
        // feito em convenção
        return produtoRepository.searchBynameLike(parteNome);
    }

    @GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
    public Iterable<Produto> obterProdutoPorPagina(
            @PathVariable int numeroPagina,@PathVariable int qtdePagina) {
        if (qtdePagina >= 5) qtdePagina = 5; 
        Pageable page = PageRequest.of(numeroPagina, qtdePagina);
        return produtoRepositoryPage.findAll(page);
    }

    //precisa do valid para funcionar as validações
    // @PostMapping(path = "/produtos")
    // Put e Post no mesmo método
    @RequestMapping(path = "/produtos", method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid Produto produto
        // @RequestParam String nome, 
        // @RequestParam double preco,
        // @RequestParam double desconto
     ){
        // rsponse body deixa claro que é um resposta com body
        // Produto produto = new Produto(nome, preco, desconto);
        // simplificando utilizando apenas o objeto
        produtoRepository.save(produto);
        return produto;
    }

    // put foi simplificado
    // @PutMapping("/produtos")
    // public Produto alterarProduto(@Validated Produto produto){
    //     produtoRepository.save(produto);
    //     return produto;
    // }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }

}

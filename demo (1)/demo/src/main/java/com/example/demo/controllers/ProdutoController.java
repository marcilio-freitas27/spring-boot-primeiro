package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// import org.springframework.web.bind.annotation.*;
import java.nio.file.AccessDeniedException; // Certifique-se de importar a classe correta

import com.example.demo.models.entities.Produto;
import com.example.demo.models.repositories.ProdutoRepository;
import com.example.demo.models.repositories.ProdutoRepositoryPage;

import jakarta.validation.Valid;

@RestController
//fornecesse acesso as operações de um controller
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    //cria um objeto automaticamente
    private ProdutoRepository produtoRepository;
    // repositório para a página de produtos
    private ProdutoRepositoryPage produtoRepositoryPage;


    @GetMapping("/{id}")
    // Alterei de optional para produto para poder utilizar o orElseThrow() - Suppliers
    public Produto obterProduto(@PathVariable int id){
        // throw para retornar para o front a mensagem a seguir
        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado com o ID: " + id));
    }

    //exceções

    @ExceptionHandler(ProdutoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleProdutoNotFoundException(ProdutoNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleAccessDeniedException(AccessDeniedException ex) {
        return "Acesso negado: " + ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex) {
        return "Erro interno do servidor: " + ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleExceptionNotFound(Exception ex) {
        return "Não encontrado: " + ex.getMessage();
    }

    // fim exceções

    @GetMapping
    public Iterable<Produto> obterProdutos(){
        //Semelhante ao Generics que o angular usa nos servicos
        System.out.println("get no produto");
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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }

}

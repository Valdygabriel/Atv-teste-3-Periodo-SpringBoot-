package com.devsuperior.userdept.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdept.entidades.Livro;
import com.devsuperior.userdept.services.LivroService;

@RestController
@RequestMapping("biblioteca")
public class LivroController {

    @Autowired
    private final LivroService livroService;

    
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    
    //Metodo para cadastrar livro
    @PostMapping("/livro")
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.cadastrarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }
    
    //Metodo para listar os livros
    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> listarTodosLivros() {
        List<Livro> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }
    
    //Metodo para alterar um livro
    @PutMapping("/livro/{idLivro}")
    public ResponseEntity<Livro> alterarLivro(@PathVariable Long idLivro, @RequestBody Livro livro) {
        Livro livroAlterado = livroService.alterarLivro(idLivro, livro);
        if (livroAlterado != null) {
            return ResponseEntity.ok(livroAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para excluir um livro
    @DeleteMapping("/livro/{idLivro}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Long idLivro) {
        livroService.excluirLivro(idLivro);
        return ResponseEntity.noContent().build();
    }

    //Metodo para buscar livro por Id
    @GetMapping("/livro/{idLivro}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long idLivro) {
        Livro livro = livroService.buscarLivroPorId(idLivro);
        return ResponseEntity.ok(livro);
    }

    //Metodo para buscar um livro por titulo
    @GetMapping("/livro")
    public ResponseEntity<List<Livro>> buscarLivroPorTitulo(@RequestParam(required = true) String titulo) {
        if (titulo != null) {
            List<Livro> livros = livroService.buscarLivroPorTitulo(titulo);
            return ResponseEntity.ok(livros);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }












}

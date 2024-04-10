package com.devsuperior.userdept.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.devsuperior.userdept.entidades.Livro;
import com.devsuperior.userdept.repositorio.LivroRepositorio;

@Service
public class LivroService {
    
    private final LivroRepositorio livroRepositorio;

    public LivroService(LivroRepositorio livroRepositorio) {
        this.livroRepositorio = livroRepositorio;
    }

    public Livro cadastrarLivro(Livro livro) {
        try{ 
        return livroRepositorio.save(livro); }
        catch(Exception exception) { 
            throw exception;
        }

    }

    public List<Livro> listarLivros() {
        try{ 
        return (List<Livro>) livroRepositorio.findAll(); }
        catch(Exception exception) {
            throw exception;
        }
    }

    public Livro buscarLivroPorId(Long id) {
        try{ 
        return livroRepositorio.findById(id).orElse(null); }
        catch(Exception exception) {
            throw exception;
        }
    }

    public void excluirLivro(Long id) {
        try{ 
        livroRepositorio.deleteById(id); }
        catch(Exception exception) {
            throw exception;
        }
    }

    public List<Livro> buscarLivroPorTitulo(String Titulo) {
        try{ 
        return livroRepositorio.findByTituloContainingIgnoreCase(Titulo); }
        catch(Exception exception) {
            throw exception;
        }
    }

    public Livro alterarLivro(Long idLivro, Livro livroAtualizado) {
        Optional<Livro> optionalLivro = livroRepositorio.findById(idLivro);
        if (optionalLivro.isPresent()) {
            Livro livroExistente = optionalLivro.get();
            livroExistente.setTitulo(livroAtualizado.getTitulo());
            livroExistente.setAutorPrincipal(livroAtualizado.getAutorPrincipal());
            livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livroExistente.setEdicao(livroAtualizado.getEdicao());
            livroExistente.setDataAlteracao(LocalDate.now()); 
            return livroRepositorio.save(livroExistente);
        } else {

            return null;
        }
}
}
    



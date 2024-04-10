package com.devsuperior.userdept.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 100)
    private String titulo;


    @Column(name="autor_principal", nullable = false, length = 150)
    private String autorPrincipal;


    @Column(name="ano_publicacao", nullable = false)
    private Integer anoPublicacao;


    @Column(nullable = false)
    private Integer edicao;


    @Column(name="data_criacao", nullable = false)
    private LocalDate dataCriacao;


    @Column(name="data_alteracao")
    private LocalDate dataAlteracao;

    // Getters e setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutorPrincipal() {
        return autorPrincipal;
    }


    public void setAutorPrincipal(String autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
    }


    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }


    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }


    public Integer getEdicao() {
        return edicao;
    }


    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }


    public LocalDate getDataCriacao() {
        return dataCriacao;
    }


    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    
    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}


package com.biblioteca.app.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titulo;
    private String autor;
    private String genero;
    private Integer anoPublicacao;
    private Boolean lido;
    private Integer nota;
    private LocalDate dataCadastro;

    public Livro(){
    }


    public Livro(long id, String titulo, String autor, String genero, Integer anoPublicacao, Boolean lido, Integer nota, LocalDate dataCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.lido = lido;
        this.nota = nota;
        this.dataCadastro = dataCadastro;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Boolean isLido() {
        return this.lido;
    }

    public Boolean getLido() {
        return this.lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }

    public Integer getNota() {
        return this.nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", autor='" + getAutor() + "'" +
            ", genero='" + getGenero() + "'" +
            ", anoPublicacao='" + getAnoPublicacao() + "'" +
            ", lido='" + isLido() + "'" +
            ", nota='" + getNota() + "'" +
            ", dataCadastro='" + getDataCadastro() + "'" +
            "}";
    }
}

package com.biblioteca.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.app.models.Livro;

public interface LivrosRepository extends CrudRepository<Livro, String>{

    Livro findById(Long id);

    Livro deleteById(long id);

}

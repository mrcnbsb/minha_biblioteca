package com.biblioteca.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.app.model.Livro;

public interface LivrosRepository extends CrudRepository<Livro, String>{

    Livro findByLivro(Long id);

    Livro deleteByILivro(long id);

}

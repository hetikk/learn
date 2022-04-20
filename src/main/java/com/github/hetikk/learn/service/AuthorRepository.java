package com.github.hetikk.learn.service;

import com.github.hetikk.learn.model.Author;

import java.util.List;

public interface AuthorRepository {

    Author getOne(Long id);

    List<Author> getAll();

    Author create(Author author);

    Author update(Long id, Author author);

    void delete(Long id);

}

package com.github.hetikk.learn.repository;

import com.github.hetikk.learn.model.Author;
import com.github.hetikk.learn.service.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Override
    public Author getOne(Long id) {
        return new Author();
    }

    @Override
    public List<Author> getAll() {
        return List.of();
    }

    @Override
    public Author create(Author author) {
        return new Author();
    }

    @Override
    public Author update(Long id, Author author) {
        return new Author();
    }

    @Override
    public void delete(Long id) {

    }

}

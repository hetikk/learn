package com.github.hetikk.learn.service;

import com.github.hetikk.learn.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author getOne(Long id) {
        return authorRepository.getOne(id);
    }

    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    public Author create(Author author) {
        return authorRepository.create(author);
    }

    public Author update(Long id, Author author) {
        return authorRepository.update(id, author);
    }

    public void delete(Long id) {
        authorRepository.delete(id);
    }

}

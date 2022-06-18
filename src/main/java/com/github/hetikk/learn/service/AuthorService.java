package com.github.hetikk.learn.service;

import com.github.hetikk.learn.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private static final Author AUTHOR = new Author();

    static {
        AUTHOR.id = 1L;
        AUTHOR.name = "Test";
    }

    public Author getOne(Long id) {
        return AUTHOR;
    }

    public List<Author> getAll() {
        return List.of(AUTHOR);
    }

    public Author create(Author author) {
        return AUTHOR;
    }

    public Author update(Long id, Author author) {
        return AUTHOR;
    }

    public void delete(Long id) {
    }

}

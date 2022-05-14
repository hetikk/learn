package com.github.hetikk.learn.service;

import com.github.hetikk.learn.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public Author getOne(Long id) {
        return authorRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    @Transactional
    public Author create(Author author) {
        author.createdAt = LocalDateTime.now();
        return authorRepository.create(author);
    }

    @Transactional
    public Author update(Long id, Author author) {
        author.id = id;
        return authorRepository.update(author);
    }

    @Transactional
    public void delete(Long id) {
        authorRepository.delete(id);
    }

}

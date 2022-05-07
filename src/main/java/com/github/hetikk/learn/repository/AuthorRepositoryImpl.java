package com.github.hetikk.learn.repository;

import com.github.hetikk.learn.model.Author;
import com.github.hetikk.learn.service.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorDao authorDao;

    @Override
    public Author getOne(Long id) {
        Optional<Author> optional = authorDao.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Entity not found. ID=" + id));
    }

    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }

    @Override
    public Author create(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Author update(Author author) {
        Author newAuthor = getOne(author.id);
        newAuthor.name = author.name;
        return authorDao.save(newAuthor);
    }

    @Override
    public void delete(Long id) {
        authorDao.deleteById(id);
    }

}

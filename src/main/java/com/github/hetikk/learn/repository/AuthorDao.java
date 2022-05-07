package com.github.hetikk.learn.repository;

import com.github.hetikk.learn.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long> {
}

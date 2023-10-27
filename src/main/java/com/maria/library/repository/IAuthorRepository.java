package com.maria.library.repository;

import com.maria.library.model.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorRepository {
    List<Author> read();

    Optional<Author> readById(Long id);

    int create(Author author);

    int update(Author author);

    void delete(Long id);
}

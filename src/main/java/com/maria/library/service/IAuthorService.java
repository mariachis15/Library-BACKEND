package com.maria.library.service;

import com.maria.library.model.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    List<Author> getAll();

    Optional<Author> getById(Long id);

    void save(Author author);

    void update(Author author);

    void delete(Long id);
}

package com.maria.library.service;

import com.maria.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getAll();

    Optional<Book> getById(Long id);

    Optional<Book> getByTitle(String  title);

    void save(Book book);

    void update(Book book);

    void delete(Long id);
}

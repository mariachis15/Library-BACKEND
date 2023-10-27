package com.maria.library.repository;

import com.maria.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
    List<Book> read();

    Optional<Book> readById(Long id);

    int create(Book book);

    int update(Book book);

    void delete(Long id);
}

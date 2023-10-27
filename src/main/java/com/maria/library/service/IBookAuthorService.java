package com.maria.library.service;

import com.maria.library.model.BookAuthor;

import java.util.List;

public interface IBookAuthorService {
    List<BookAuthor> getAll();

    void save(BookAuthor bookAuthor);

    void update(BookAuthor bookAuthor);

    void delete(Long bookId, Long authorId);
}

package com.maria.library.repository;

import com.maria.library.model.BookAuthor;

import java.util.List;


public interface IBookAuthorRepository {
    List<BookAuthor> read();

    int create(BookAuthor bookAuthor);

    int update(BookAuthor bookAuthor);

    void delete(Long bookId, Long authorId);


}

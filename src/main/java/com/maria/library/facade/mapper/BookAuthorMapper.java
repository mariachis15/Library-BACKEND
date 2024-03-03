package com.maria.library.facade.mapper;

import com.maria.library.model.BookAuthor;
import org.springframework.stereotype.Component;

@Component
public class BookAuthorMapper {

    public BookAuthor mapToEntity(long authorId, long bookId) {
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setAuthorId(authorId);
        bookAuthor.setBookId(bookId);
        return bookAuthor;
    }
}

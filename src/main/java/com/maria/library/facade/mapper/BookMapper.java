package com.maria.library.facade.mapper;

import com.maria.library.facade.dto.BookDto;
import com.maria.library.model.Book;
import com.maria.library.model.BookAuthor;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setCategoryId(bookDto.getCategoryId());
        book.setTitle(bookDto.getTitle());
        book.setPublicationYear(bookDto.getPublicationYear());
        return book;
    }
}

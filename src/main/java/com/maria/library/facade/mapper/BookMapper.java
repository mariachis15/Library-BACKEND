package com.maria.library.facade.mapper;

import com.maria.library.facade.dto.BookDetailsDto;
import com.maria.library.facade.dto.BookDto;
import com.maria.library.model.Author;
import com.maria.library.model.Book;
import com.maria.library.model.BookAuthor;
import com.maria.library.model.Category;
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

    public BookDetailsDto mapToEntity(Book book, Author author, Category category) {
        return (new BookDetailsDto(book.getTitle(), book.getPublicationYear(), category.getName(), author.getFirstname() + " " + author.getLastname()));
    }
}

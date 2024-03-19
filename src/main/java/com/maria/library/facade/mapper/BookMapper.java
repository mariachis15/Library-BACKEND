package com.maria.library.facade.mapper;

import com.maria.library.facade.dto.BookDetailsDto;
import com.maria.library.facade.dto.BookDto;
import com.maria.library.model.Author;
import com.maria.library.model.Book;
import com.maria.library.model.Category;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapToEntity(BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getPublicationYear(), bookDto.getCategoryId(), bookDto.getAuthorId());
    }

    public BookDetailsDto mapToBookDetailsDto(Book book, Author author, Category category) {
        return new BookDetailsDto(book.getId(), book.getTitle(), book.getPublicationYear(), category.getName(), author.getFirstname() + " " + author.getLastname());
    }

    public Book mapToEntity(Long id, BookDto bookDto) {
        return new Book(id, bookDto.getTitle(), bookDto.getPublicationYear(), bookDto.getCategoryId(), bookDto.getAuthorId());
    }
}

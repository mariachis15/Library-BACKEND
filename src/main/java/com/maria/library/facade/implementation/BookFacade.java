package com.maria.library.facade.implementation;

import com.maria.library.common.Response;
import com.maria.library.exceptions.AuthorNotFoundException;
import com.maria.library.exceptions.BookAlreadyExistingException;
import com.maria.library.facade.IBookFacade;
import com.maria.library.facade.dto.BookDto;
import com.maria.library.facade.mapper.BookAuthorMapper;
import com.maria.library.facade.mapper.BookMapper;
import com.maria.library.model.Book;
import com.maria.library.model.BookAuthor;
import com.maria.library.service.implementation.AuthorService;
import com.maria.library.service.implementation.BookAuthorService;
import com.maria.library.service.implementation.BookService;
import org.springframework.stereotype.Component;

@Component
public class BookFacade implements IBookFacade {
    private final BookService bookService;
    private final AuthorService authorService;
    private final BookAuthorService bookAuthorService;
    private final BookMapper bookMapper;
    private final BookAuthorMapper bookAuthorMapper;

    public BookFacade(BookService bookService, AuthorService authorService, BookAuthorService bookAuthorService, BookMapper bookMapper, BookAuthorMapper bookAuthorMapper) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookAuthorService = bookAuthorService;
        this.bookMapper = bookMapper;
        this.bookAuthorMapper = bookAuthorMapper;
    }

    public Response<BookDto> addBook(BookDto bookDto) {
        var author = authorService.getById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException("The author does not exist."));
        author.setNumberOfBooks(author.getNumberOfBooks() + 1);
        authorService.update(author);

        var existingBook = bookService.getByTitle(bookDto.getTitle());
        if (existingBook.isPresent()) {
            throw new BookAlreadyExistingException("This book already exists");
        }

        Book book = bookMapper.mapToEntity(bookDto);
        bookService.save(book);

        Book savedBook = bookService.getByTitle(bookDto.getTitle()).get();
        BookAuthor bookAuthor = bookAuthorMapper.mapToEntity(bookDto.getAuthorId(), savedBook.getId());
        bookAuthorService.save(bookAuthor);
        return new Response<>(bookDto);
    }
}

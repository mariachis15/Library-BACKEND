package com.maria.library.facade;

import com.maria.library.common.Response;
import com.maria.library.facade.dto.BookDetailsDto;
import com.maria.library.facade.dto.BookDto;

import java.util.List;

public interface IBookFacade {
    Response<BookDto> addBook(BookDto bookDto);

    Response<List<BookDetailsDto>> getAllBooks();

    Response<List<BookDetailsDto>> getBooksByAuthor(Long authorId);

    Response<List<BookDetailsDto>> getBooksByClient(Long clientId);

    Response<List<BookDetailsDto>> getAvailableBooks();

    void deleteBook(Long id);

    void updateBook(Long id, BookDto bookDto);
}

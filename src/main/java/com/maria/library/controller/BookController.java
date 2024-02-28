package com.maria.library.controller;

import com.maria.library.common.Response;
import com.maria.library.facade.IBookFacade;
import com.maria.library.facade.dto.BookDto;
import com.maria.library.facade.implementation.BookFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final IBookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @PostMapping
    public ResponseEntity<Response<BookDto>> addNewBook (@RequestBody BookDto bookDto) {
        Response<BookDto> response = bookFacade.addBook(bookDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

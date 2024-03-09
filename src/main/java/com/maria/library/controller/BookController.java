package com.maria.library.controller;

import com.maria.library.common.Response;
import com.maria.library.facade.IBookFacade;
import com.maria.library.facade.dto.BookDetailsDto;
import com.maria.library.facade.dto.BookDto;
import com.maria.library.facade.implementation.BookFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final IBookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @PostMapping
    public ResponseEntity<Response<BookDto>> addNewBook(@RequestBody BookDto bookDto) {
        Response<BookDto> response = bookFacade.addBook(bookDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Response<List<BookDetailsDto>>> getAllBooks() {
        Response<List<BookDetailsDto>> response = bookFacade.getAllBooks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<Response<List<BookDetailsDto>>> getBooksByAuthor(@RequestParam Long authorId) {
        Response<List<BookDetailsDto>> response = bookFacade.getBooksByAuthor(authorId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/client")
    public ResponseEntity<Response<List<BookDetailsDto>>> getBooksByClient(@RequestParam Long clientId) {
        Response<List<BookDetailsDto>> response = bookFacade.getBooksByClient(clientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/availableBooks")
    public ResponseEntity<Response<List<BookDetailsDto>>> getAvailableBooks() {
        Response<List<BookDetailsDto>> response = bookFacade.getAvailableBooks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

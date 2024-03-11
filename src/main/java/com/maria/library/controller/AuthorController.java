package com.maria.library.controller;

import com.maria.library.common.Response;
import com.maria.library.facade.IAuthorFacade;
import com.maria.library.facade.dto.AuthorDetailsDto;
import com.maria.library.facade.dto.AuthorDto;
import com.maria.library.facade.implementation.AuthorFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final IAuthorFacade authorFacade;

    public AuthorController(AuthorFacade authorFacade) {
        this.authorFacade = authorFacade;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody AuthorDto authorDto) {
        authorFacade.addAuthor(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Response<List<AuthorDetailsDto>>> getAllAuthors() {
        Response<List<AuthorDetailsDto>> response = authorFacade.getAllAuthors();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAuthor(@RequestParam Long id) {
        authorFacade.deleteAuthor(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

package com.maria.library.controller;

import com.maria.library.facade.IAuthorFacade;
import com.maria.library.facade.dto.AuthorDto;
import com.maria.library.facade.implementation.AuthorFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package com.maria.library.facade.mapper;

import com.maria.library.facade.dto.AuthorDetailsDto;
import com.maria.library.facade.dto.AuthorDto;
import com.maria.library.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author mapToEntity(AuthorDto authorDto) {
        Author author = new Author(authorDto.getFirstname(), authorDto.getLastname(), authorDto.getNumberOfBooks());
        return author;
    }

    public AuthorDetailsDto mapToAuthorDto(Author author) {
        AuthorDetailsDto authorDetailsDto = new AuthorDetailsDto(author.getId(), author.getFirstname(), author.getLastname(), author.getNumberOfBooks());
        return authorDetailsDto;
    }
}

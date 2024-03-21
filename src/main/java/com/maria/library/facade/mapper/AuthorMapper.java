package com.maria.library.facade.mapper;

import com.maria.library.facade.dto.AuthorDetailsDto;
import com.maria.library.facade.dto.AuthorDto;
import com.maria.library.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author mapToEntity(AuthorDto authorDto) {
        return new Author(authorDto.getFirstname(), authorDto.getLastname(), authorDto.getNumberOfBooks());
    }

    public AuthorDetailsDto mapToAuthorDto(Author author) {
        return new AuthorDetailsDto(author.getId(), author.getFirstname(), author.getLastname(), author.getNumberOfBooks());
    }

    public Author mapToEntity(Long id, AuthorDto authorDto) {
        return new Author(id, authorDto.getFirstname(), authorDto.getLastname(), authorDto.getNumberOfBooks());
    }
}

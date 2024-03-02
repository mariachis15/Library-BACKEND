package com.maria.library.facade.mapper;

import com.maria.library.facade.dto.AuthorDto;
import com.maria.library.facade.dto.RegisterDto;
import com.maria.library.model.Author;
import com.maria.library.model.UserData;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author mapToEntity(AuthorDto authorDto) {
        Author authorData   = new Author(authorDto.getFirstname(), authorDto.getLastname(), authorDto.getNumberOfBooks());
        return authorData;
    }
}

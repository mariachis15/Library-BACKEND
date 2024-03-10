package com.maria.library.facade.implementation;

import com.maria.library.common.Response;
import com.maria.library.facade.IAuthorFacade;
import com.maria.library.facade.dto.AuthorDetailsDto;
import com.maria.library.facade.dto.AuthorDto;
import com.maria.library.facade.mapper.AuthorMapper;
import com.maria.library.model.Author;
import com.maria.library.service.implementation.AuthorService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorFacade implements IAuthorFacade {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorFacade(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    public void addAuthor(AuthorDto authorDto) {
        Author author = authorMapper.mapToEntity(authorDto);
        authorService.save(author);
    }

    @Override
    public Response<List<AuthorDetailsDto>> getAllAuthors() {
        List<AuthorDetailsDto> authorDetailsDtoList = new ArrayList<>();
        List<Author> authors = authorService.getAll();
        for (var author : authors) {
            AuthorDetailsDto authorDetailsDto = authorMapper.mapToAuthorDto(author);
            authorDetailsDtoList.add(authorDetailsDto);
        }
        return new Response<>(authorDetailsDtoList);
    }
}

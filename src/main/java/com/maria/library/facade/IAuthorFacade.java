package com.maria.library.facade;

import com.maria.library.common.Response;
import com.maria.library.facade.dto.AuthorDetailsDto;
import com.maria.library.facade.dto.AuthorDto;

import java.util.List;

public interface IAuthorFacade {
    void addAuthor(AuthorDto authorDto);
    Response<List<AuthorDetailsDto>> getAllAuthors();
}

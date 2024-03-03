package com.maria.library.facade.implementation;

import com.maria.library.facade.IAuthorFacade;
import com.maria.library.facade.dto.AuthorDto;
import com.maria.library.facade.mapper.AuthorMapper;
import com.maria.library.model.Author;
import com.maria.library.service.implementation.AuthorService;
import org.springframework.stereotype.Component;

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
}

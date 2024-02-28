package com.maria.library.service.implementation;

import com.maria.library.exceptions.AuthorNotFoundException;
import com.maria.library.model.Author;
import com.maria.library.repository.IAuthorRepository;
import com.maria.library.repository.implementation.AuthorRepository;
import com.maria.library.service.IAuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    private final IAuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.read();
    }

    @Override
    public Optional<Author> getById(Long id) {
        Optional<Author> author = authorRepository.readById(id);
        if (author.isEmpty()) {
            return Optional.empty();
        }
        return author;
    }

    @Override
    public void save(Author author) {
        authorRepository.create(author);
    }

    @Override
    public void update(Author author) {
        int changedRows = authorRepository.update(author);
        if (changedRows == 0) {
            throw new AuthorNotFoundException("The author does not exist.");
        }
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(id);
    }
}

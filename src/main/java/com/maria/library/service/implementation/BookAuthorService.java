package com.maria.library.service.implementation;

import com.maria.library.exceptions.BookAuthorNotFoundException;
import com.maria.library.model.BookAuthor;
import com.maria.library.repository.IBookAuthorRepository;
import com.maria.library.repository.implementation.BookAuthorRepository;
import com.maria.library.service.IBookAuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService implements IBookAuthorService {
    private final IBookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    @Override
    public List<BookAuthor> getAll() {
        return bookAuthorRepository.read();
    }

    @Override
    public void save(BookAuthor bookAuthor) {
        bookAuthorRepository.create(bookAuthor);
    }

    @Override
    public void update(BookAuthor bookAuthor) {
        int changedRows = bookAuthorRepository.update(bookAuthor);
        if (changedRows == 0) {
            throw new BookAuthorNotFoundException("The book from this author does not exist.");
        }
    }

    @Override
    public void delete(Long bookId, Long authorId) {
        bookAuthorRepository.delete(bookId, authorId);
    }
}

package com.maria.library.service.implementation;

import com.maria.library.exceptions.BookNotFoundException;
import com.maria.library.model.Book;
import com.maria.library.repository.IBookRepository;
import com.maria.library.repository.implementation.BookRepository;
import com.maria.library.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.read();
    }

    @Override
    public Optional<Book> getById(Long id) {
        Optional<Book> book = bookRepository.readById(id);
        if (book.isEmpty()) {
            throw new BookNotFoundException("The book does not exist.");
        }
        return book;
    }

    @Override
    public Optional<Book> getByTitle(String title) {
        Optional<Book> book = bookRepository.readByTitle(title);
        return book;
    }

    @Override
    public void save(Book book) {
        bookRepository.create(book);
    }

    @Override
    public void update(Book book) {
        int changedRows = bookRepository.update(book);
        if (changedRows == 0) {
            throw new BookNotFoundException("The book does not exist.");
        }
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }
}

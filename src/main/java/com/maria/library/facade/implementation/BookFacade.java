package com.maria.library.facade.implementation;

import com.maria.library.common.Response;
import com.maria.library.exceptions.AuthorNotFoundException;
import com.maria.library.exceptions.BookAlreadyExistingException;
import com.maria.library.facade.IBookFacade;
import com.maria.library.facade.dto.BookDetailsDto;
import com.maria.library.facade.dto.BookDto;
import com.maria.library.facade.mapper.BookAuthorMapper;
import com.maria.library.facade.mapper.BookMapper;
import com.maria.library.model.Author;
import com.maria.library.model.Book;
import com.maria.library.model.BookAuthor;
import com.maria.library.model.Category;
import com.maria.library.service.implementation.AuthorService;
import com.maria.library.service.implementation.BookAuthorService;
import com.maria.library.service.implementation.BookService;
import com.maria.library.service.implementation.CategoryService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookFacade implements IBookFacade {
    private final BookService bookService;
    private final AuthorService authorService;
    private final BookAuthorService bookAuthorService;
    private final BookMapper bookMapper;
    private final BookAuthorMapper bookAuthorMapper;
    private final CategoryService categoryService;

    public BookFacade(BookService bookService, AuthorService authorService, BookAuthorService bookAuthorService, BookMapper bookMapper, BookAuthorMapper bookAuthorMapper, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookAuthorService = bookAuthorService;
        this.bookMapper = bookMapper;
        this.bookAuthorMapper = bookAuthorMapper;
        this.categoryService = categoryService;
    }

    public Response<BookDto> addBook(BookDto bookDto) {
        var author = authorService.getById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException("The author does not exist."));
        author.setNumberOfBooks(author.getNumberOfBooks() + 1);
        authorService.update(author);

        var existingBook = bookService.getByTitle(bookDto.getTitle());
        if (existingBook.isPresent()) {
            throw new BookAlreadyExistingException("This book already exists");
        }

        Book book = bookMapper.mapToEntity(bookDto);
        bookService.save(book);

        Book savedBook = bookService.getByTitle(bookDto.getTitle()).get();
        BookAuthor bookAuthor = bookAuthorMapper.mapToEntity(bookDto.getAuthorId(), savedBook.getId());
        bookAuthorService.save(bookAuthor);
        return new Response<>(bookDto);
    }

    @Override
    public Response<List<BookDetailsDto>> getAllBooks() {
        List<Book> books = bookService.getAll();
        List<BookAuthor> bookAuthors = bookAuthorService.getAll();
        List<Author> authors = authorService.getAll();
        List<Category> categories = categoryService.getAll();
        return getList(books, bookAuthors, authors, categories);
    }

    @Override
    public Response<List<BookDetailsDto>> getBooksByAuthor(Long authorId) {
        List<Book> books = bookService.getAll();
        List<BookAuthor> bookAuthors = bookAuthorService.getAll();
        List<Author> authors = authorService.getAll();
        List<Category> categories = categoryService.getAll();
        List<BookDetailsDto> bookDetailsDtoList = new ArrayList<>();

        bookAuthors = bookAuthors.stream().filter(ba -> ba.getAuthorId() == authorId).toList();

        for (var bookAuthor : bookAuthors) {
            var author = authors
                    .stream()
                    .filter(a -> a.getId() == bookAuthor.getAuthorId())
                    .findFirst().get();

            var book = books
                    .stream()
                    .filter(b -> b.getId() == bookAuthor.getBookId())
                    .findFirst().get();

            var category = categories
                    .stream()
                    .filter(c -> c.getId() == book.getCategoryId())
                    .findFirst().get();

            BookDetailsDto bookDetailsDto = bookMapper.mapToBookDetailsDto(book, author, category);
            bookDetailsDtoList.add(bookDetailsDto);
        }
        return new Response<>(bookDetailsDtoList);
    }

    @Override
    public Response<List<BookDetailsDto>> getBooksByClient(Long clientId) {
        List<Book> books = bookService.getAll();
        List<BookAuthor> bookAuthors = bookAuthorService.getAll();
        List<Author> authors = authorService.getAll();
        List<Category> categories = categoryService.getAll();
        books = books.stream().filter(b -> b.getClientId() == clientId).toList();
        return getList(books, bookAuthors, authors, categories);
    }

    @Override
    public Response<List<BookDetailsDto>> getAvailableBooks() {
        List<Book> books = bookService.getAll();
        List<BookAuthor> bookAuthors = bookAuthorService.getAll();
        List<Author> authors = authorService.getAll();
        List<Category> categories = categoryService.getAll();
        books = books.stream().filter(b -> b.getClientId() == 0).toList();
        return getList(books, bookAuthors, authors, categories);

    }

    private Response<List<BookDetailsDto>> getList(List<Book> books, List<BookAuthor> bookAuthors, List<Author> authors, List<Category> categories) {
        List<BookDetailsDto> bookDetailsDtoList = new ArrayList<>();
        for (var book : books) {
            var bookAuthor = bookAuthors
                    .stream()
                    .filter(b -> b.getBookId() == book.getId())
                    .findFirst().get();

            var author = authors
                    .stream()
                    .filter(a -> a.getId() == bookAuthor.getAuthorId())
                    .findFirst().get();

            var category = categories
                    .stream()
                    .filter(c -> c.getId() == book.getCategoryId())
                    .findFirst().get();

            BookDetailsDto bookDetailsDto = bookMapper.mapToBookDetailsDto(book, author, category);
            bookDetailsDtoList.add(bookDetailsDto);
        }
        return new Response<>(bookDetailsDtoList);
    }
}

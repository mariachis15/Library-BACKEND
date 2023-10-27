package com.maria.library.repository.implementation;

import com.maria.library.mapper.BookMapper;
import com.maria.library.model.Book;
import com.maria.library.repository.IBookRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository implements IBookRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String READ_ALL_QUERY = "SELECT * FROM book;";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM book WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO book(title, publicationYear, clientId, categoryId) VALUES (?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE book SET title = ?, publicationYear = ?, clientId = ?, categoryId = ?;";
    private static final String DELETE_QUERY = "DELETE FROM book WHERE id = ?;";

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> read() {
        return jdbcTemplate.query(READ_ALL_QUERY, new BookMapper());
    }

    @Override
    public Optional<Book> readById(Long id) {
        return jdbcTemplate.query(READ_BY_ID_QUERY, new BookMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int create(Book book) {
        return jdbcTemplate.update(CREATE_QUERY, book.getTitle(), book.getPublicationYear(), book.getClientId(), book.getCategoryId());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update(UPDATE_QUERY, book.getTitle(), book.getPublicationYear(), book.getClientId(), book.getCategoryId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}

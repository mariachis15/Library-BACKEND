package com.maria.library.repository.implementation;

import com.maria.library.repository.mapper.BookAuthorMapper;
import com.maria.library.model.BookAuthor;
import com.maria.library.repository.IBookAuthorRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookAuthorRepository implements IBookAuthorRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String READ_ALL_QUERY = "SELECT * FROM book_author;";
    private static final String CREATE_QUERY = "INSERT INTO book_author(bookId, authorId) VALUES (?, ?);";
    private static final String UPDATE_QUERY = "UPDATE book_author SET bookId = ?, authorId = ?;";
    private static final String DELETE_QUERY = "DELETE FROM book_author WHERE bookId = ? AND authorId = ?;";

    public BookAuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BookAuthor> read() {
        return jdbcTemplate.query(READ_ALL_QUERY, new BookAuthorMapper());
    }


    @Override
    public int create(BookAuthor bookAuthor) {
        return jdbcTemplate.update(CREATE_QUERY, bookAuthor.getBookId(), bookAuthor.getAuthorId());
    }

    @Override
    public int update(BookAuthor bookAuthor) {
        return jdbcTemplate.update(UPDATE_QUERY, bookAuthor.getBookId(), bookAuthor.getAuthorId());
    }

    @Override
    public void delete(Long bookId, Long authorId) {
        jdbcTemplate.update(DELETE_QUERY, bookId, authorId);
    }

}

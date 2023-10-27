package com.maria.library.mapper;

import com.maria.library.model.BookAuthor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAuthorMapper implements RowMapper<BookAuthor> {
    @Override
    public BookAuthor mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setBookId(rs.getLong("bookId"));
        bookAuthor.setAuthorId(rs.getLong("authorId"));
        return bookAuthor;
    }
}

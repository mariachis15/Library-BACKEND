package com.maria.library.mapper;

import com.maria.library.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("title"));
        book.setPublicationYear(rs.getLong("publicationYear"));
        book.setClientId(rs.getLong("clientId"));
        book.setCategoryId(rs.getLong("categoryId"));
        return book;
    }
}

package com.maria.library.mapper;

import com.maria.library.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getLong("id"));
        author.setFirstname(rs.getString("firstName"));
        author.setLastname(rs.getString("lastName"));
        author.setNumberOfBooks(rs.getLong("numberOfBooks"));
        return author;
    }
}

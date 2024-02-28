package com.maria.library.repository.implementation;

import com.maria.library.repository.mapper.AuthorMapper;
import com.maria.library.model.Author;
import com.maria.library.repository.IAuthorRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements IAuthorRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String READ_ALL_QUERY = "SELECT * FROM author;";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM author WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO author(firstName, lastName, numberOfBooks) VALUES (?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE author SET firstName = ?, lastName = ?, numberOfBooks = ?;";
    private static final String DELETE_QUERY = "DELETE FROM author WHERE id = ?;";

    public AuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Author> read() {
        return jdbcTemplate.query(READ_ALL_QUERY, new AuthorMapper());
    }

    @Override
    public Optional<Author> readById(Long id) {
        return jdbcTemplate.query(READ_BY_ID_QUERY, new AuthorMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int create(Author author) {
        return jdbcTemplate.update(CREATE_QUERY, author.getFirstname(), author.getLastname(), author.getNumberOfBooks());
    }

    @Override
    public int update(Author author) {
        return jdbcTemplate.update(UPDATE_QUERY, author.getFirstname(), author.getLastname(), author.getNumberOfBooks());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}

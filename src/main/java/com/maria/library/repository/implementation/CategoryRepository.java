package com.maria.library.repository.implementation;

import com.maria.library.repository.mapper.CategoryMapper;
import com.maria.library.model.Category;
import com.maria.library.repository.ICategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class CategoryRepository implements ICategoryRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String READ_ALL_QUERY = "SELECT * FROM category;";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM category WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO category(name) VALUES (?);";
    private static final String UPDATE_QUERY = "UPDATE category SET name = ?;";
    private static final String DELETE_QUERY = "DELETE FROM category WHERE id = ?;";

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> read() {
        return jdbcTemplate.query(READ_ALL_QUERY, new CategoryMapper());
    }

    @Override
    public Optional<Category> readById(Long id) {
        return jdbcTemplate.query(READ_BY_ID_QUERY, new CategoryMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int create(Category category) {
        return jdbcTemplate.update(CREATE_QUERY, category.getName());
    }

    @Override
    public int update(Category category) {
        return jdbcTemplate.update(UPDATE_QUERY, category.getName());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}

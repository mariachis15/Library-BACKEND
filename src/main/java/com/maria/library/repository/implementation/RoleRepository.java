package com.maria.library.repository.implementation;

import com.maria.library.mapper.RoleMapper;
import com.maria.library.model.Role;
import com.maria.library.repository.IRoleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepository implements IRoleRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final String READ_ALL_QUERY = "SELECT * FROM role;";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM role WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO role VALUES (?);";
    private static final String UPDATE_QUERY = "UPDATE role SET name(name) = ?;";
    private static final String DELETE_QUERY = "DELETE FROM role WHERE id = ?;";

    public RoleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> read() {
        return jdbcTemplate.query(READ_ALL_QUERY, new RoleMapper());
    }

    @Override
    public Optional<Role> readById(Long id) {
        return jdbcTemplate.query(READ_BY_ID_QUERY, new RoleMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int create(Role role) {
        return jdbcTemplate.update(CREATE_QUERY, role.getName());
    }

    @Override
    public int update(Role role) {
        return jdbcTemplate.update(UPDATE_QUERY, role.getName());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}

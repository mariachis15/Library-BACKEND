package com.maria.library.repository.implementation;

import com.maria.library.repository.mapper.UserDataMapper;
import com.maria.library.model.UserData;
import com.maria.library.repository.IUserDataRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDataRepository implements IUserDataRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final String READ_ALL_QUERY = "SELECT * FROM user_data;";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM user_data WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO user_data(username, passwordUser, firstName, lastName, roleId) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE user_data SET username = ?, passwordUser = ?, firstName = ?, lastName = ?, roleId = ?;";
    private static final String DELETE_QUERY = "DELETE FROM user_data WHERE id = ?;";

    public UserDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserData> read() {
        return jdbcTemplate.query(READ_ALL_QUERY, new UserDataMapper());
    }

    @Override
    public Optional<UserData> readById(Long id) {
        return jdbcTemplate.query(READ_BY_ID_QUERY, new UserDataMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int create(UserData userData) {
        return jdbcTemplate.update(CREATE_QUERY, userData.getUsername(), userData.getPasswordUser(), userData.getFirstname(), userData.getLastname(), userData.getRoleId());
    }

    @Override
    public int update(UserData userData) {
        return jdbcTemplate.update(UPDATE_QUERY, userData.getUsername(), userData.getPasswordUser(), userData.getFirstname(), userData.getLastname(), userData.getRoleId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}

package com.maria.library.mapper;

import com.maria.library.model.UserData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataMapper implements RowMapper<UserData> {
    @Override
    public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserData userData = new UserData();
        userData.setId(rs.getLong("id"));
        userData.setUsername(rs.getString("username"));
        userData.setPasswordUser(rs.getString("passwordUser"));
        userData.setFirstname(rs.getString("firstName"));
        userData.setLastname(rs.getString("lastName"));
        userData.setRoleId(rs.getLong("roleId"));
        return userData;

    }

}

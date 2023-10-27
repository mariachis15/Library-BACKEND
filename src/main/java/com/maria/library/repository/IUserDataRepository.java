package com.maria.library.repository;

import com.maria.library.model.UserData;

import java.util.List;
import java.util.Optional;

public interface IUserDataRepository {
    List<UserData> read();

    Optional<UserData> readById(Long id);

    int create(UserData userData);

    int update(UserData userData);

    void delete(Long id);

}

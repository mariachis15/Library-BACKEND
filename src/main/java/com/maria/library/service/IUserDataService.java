package com.maria.library.service;

import com.maria.library.model.UserData;

import java.util.List;
import java.util.Optional;

public interface IUserDataService {
    List<UserData> getAll();

    Optional<UserData> getById(Long id);

    void save(UserData userData);

    void update(UserData userData);

    void delete(Long id);
}

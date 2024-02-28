package com.maria.library.repository;

import com.maria.library.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleRepository {
    List<Role> read();

    Optional<Role> readById(Long id);

    Optional<Long> readIdByName(String name);

    int create(Role role);

    int update(Role role);

    void delete(Long id);
}

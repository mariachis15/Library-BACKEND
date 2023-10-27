package com.maria.library.service;

import com.maria.library.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> getAll();

    Optional<Role> getById(Long id);

    void save(Role role);

    void update(Role role);

    void delete(Long id);}

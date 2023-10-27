package com.maria.library.service;

import com.maria.library.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAll();

    Optional<Category> getById(Long id);

    void save(Category category);

    void update(Category category);

    void delete(Long id);
}

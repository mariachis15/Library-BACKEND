package com.maria.library.repository;

import com.maria.library.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {
    List<Category> read();

    Optional<Category> readById(Long id);

    int create(Category category);

    int update(Category category);

    void delete(Long id);
}

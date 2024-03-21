package com.maria.library.facade.mapper;

import com.maria.library.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category mapToEntity(String categoryName) {
        return new Category(categoryName);
    }

    public Category mapToEntity(Long id, String categoryName) {
        return new Category(id, categoryName);
    }
}
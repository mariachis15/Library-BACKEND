package com.maria.library.facade.mapper;

import com.maria.library.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category mapToEntity(String name) {
        Category category = new Category(name);
        return category;
    }
}

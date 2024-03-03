package com.maria.library.facade.implementation;

import com.maria.library.facade.ICategoryFacade;
import com.maria.library.facade.mapper.CategoryMapper;
import com.maria.library.model.Category;
import com.maria.library.service.ICategoryService;
import org.springframework.stereotype.Component;

@Component
public class CategoryFacade implements ICategoryFacade {
    private final CategoryMapper categoryMapper;
    private final ICategoryService categoryService;

    public CategoryFacade(CategoryMapper categoryMapper, ICategoryService categoryService) {
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
    }

    public void addCategory(String name) {
        Category category = categoryMapper.mapToEntity(name);
        categoryService.save(category);
    }
}

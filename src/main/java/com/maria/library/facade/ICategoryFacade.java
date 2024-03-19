package com.maria.library.facade;

import com.maria.library.common.Response;
import com.maria.library.model.Category;

import java.util.List;

public interface ICategoryFacade {
    void addCategory(String categoryName);

    Response<List<Category>> getAllCategories();

    void deleteCategory(Long id);

    void updateCategory(Long id, String categoryName);
}

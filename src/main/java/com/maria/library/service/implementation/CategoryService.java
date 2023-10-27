package com.maria.library.service.implementation;

import com.maria.library.exceptions.CategoryNotFoundException;
import com.maria.library.model.Category;
import com.maria.library.repository.ICategoryRepository;
import com.maria.library.repository.implementation.CategoryRepository;
import com.maria.library.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.read();
    }

    @Override
    public Optional<Category> getById(Long id) {
        Optional<Category> category = categoryRepository.readById(id);
        if (category.isEmpty()) {
            throw new CategoryNotFoundException("The category does not exist.");
        }
        return category;
    }

    @Override
    public void save(Category category) {
        categoryRepository.create(category);
    }

    @Override
    public void update(Category category) {
        int changedRows = categoryRepository.update(category);
        if (changedRows == 0) {
            throw new CategoryNotFoundException("The category does not exist.");
        }
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}

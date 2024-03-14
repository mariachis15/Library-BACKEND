package com.maria.library.controller;

import com.maria.library.common.Response;
import com.maria.library.facade.ICategoryFacade;

import com.maria.library.facade.dto.BookDetailsDto;
import com.maria.library.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryFacade categoryFacade;

    public CategoryController(ICategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestParam String categoryName) {
        categoryFacade.addCategory(categoryName);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Response<List<Category>>> getAllCategories() {
        Response<List<Category>> response = categoryFacade.getAllCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCategory(@RequestParam Long id) {
        categoryFacade.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

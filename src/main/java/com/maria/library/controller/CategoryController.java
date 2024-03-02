package com.maria.library.controller;

import com.maria.library.facade.ICategoryFacade;
import com.maria.library.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryFacade categoryFacade;

    public CategoryController(ICategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestParam String name) {
        categoryFacade.addCategory(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

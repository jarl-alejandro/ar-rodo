package com.jarl.artodo.category.infrastructure.controller;

import com.jarl.artodo.category.application.CategoriesResponse;
import com.jarl.artodo.category.application.CategoryResponse;
import com.jarl.artodo.category.application.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> listCategories() {
        CategoriesResponse list = service.list();
        return new ResponseEntity<>(list.categories(), HttpStatus.OK);
    }
}

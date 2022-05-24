package com.jarl.artodo.category.application;

import com.jarl.artodo.category.domain.*;
import com.jarl.artodo.shared.domain.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public void create(CategoryId id, CategoryName name, CategoryDescription description, CategoryEmoji emoji) {
        Category category = Category.create(id, name, description, emoji);
        repository.save(category);
    }

    public CategoryResponse findById(CategoryId id) throws Exception {
         return repository.findById(id)
            .map(CategoryResponse::fromAggregate)
            .orElseThrow(() -> new Exception("category no exist"));
    }

    public CategoriesResponse list() {
        List<CategoryResponse> categories = repository.list().stream()
            .map(CategoryResponse::fromAggregate)
            .collect(Collectors.toList());

        return new CategoriesResponse(categories);
    }
}

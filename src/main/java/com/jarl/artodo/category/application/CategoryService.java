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

    public void create(CategoryDTO categoryDTO) {
        CategoryId id = CategoryId.generateCategoryId();
        CategoryName name = new CategoryName(categoryDTO.getName());
        CategoryDescription description = new CategoryDescription(categoryDTO.getDescription());
        CategoryEmoji emoji = new CategoryEmoji(categoryDTO.getEmoji());

        Category category = Category.create(id, name, description, emoji);
        repository.save(category);
    }

    public CategoryDTO findById(String id) throws Exception {
         return repository.findById(new CategoryId(id))
            .map(CategoryDTO::mapperCategoryDTO)
            .orElseThrow(() -> new Exception("category no exist"));
    }

    public List<CategoryDTO> list() {
        return repository.list().stream()
            .map(CategoryDTO::mapperCategoryDTO)
            .collect(Collectors.toList());
    }
}

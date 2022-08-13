package com.jarl.artodo.category.infrastructure.persistence;

import com.jarl.artodo.category.domain.*;
import com.jarl.artodo.shared.domain.Service;

import java.util.*;

public class InMemoryCategoryRepository implements CategoryRepository {
    private HashMap<UUID, Category> categories = new HashMap<>();

    public InMemoryCategoryRepository() {
        this.categories.put(
            CategoryId.generateCategoryId().value(),
            Category.create(
                CategoryId.generateCategoryId(),
                new CategoryName("jarl"),
                new CategoryDescription("desciption"),
                new CategoryEmoji("🤣👌")
            )
        );
    }

    @Override
    public void save(Category category) {
        categories.put(category.getId().value(), category);
    }

    @Override
    public Optional<Category> findById(CategoryId id) {
        return Optional.ofNullable(categories.get(id.value()));
    }

    @Override
    public List<Category> list() {
        return new ArrayList<>(categories.values());
    }
}

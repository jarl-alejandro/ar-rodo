package com.jarl.artodo.category.domain;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    public void save(Category category);
    public Optional<Category> findById(CategoryId id);
    public List<Category> list();
}

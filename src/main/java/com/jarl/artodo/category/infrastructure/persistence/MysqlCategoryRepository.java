package com.jarl.artodo.category.infrastructure.persistence;

import com.jarl.artodo.category.domain.Category;
import com.jarl.artodo.category.domain.CategoryId;
import com.jarl.artodo.category.domain.CategoryRepository;
import com.jarl.artodo.category.infrastructure.persistence.jpa.CategoryEntity;
import com.jarl.artodo.category.infrastructure.persistence.jpa.CategoryJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MysqlCategoryRepository implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    public MysqlCategoryRepository(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public void save(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity(
            category.getId().toString(),
            category.getName().value(),
            category.getDescription().value(),
            category.getEmoji().value()
        );
        categoryJpaRepository.save(categoryEntity);
    }

    @Override
    public Optional<Category> findById(CategoryId id) {
        return categoryJpaRepository.findById(id.toString())
            .map(CategoryEntity::mapperToCategory);
    }

    @Override
    public List<Category> list() {
        return categoryJpaRepository.findAll().stream()
            .map(CategoryEntity::mapperToCategory)
            .collect(Collectors.toList());
    }
}

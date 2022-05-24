package com.jarl.artodo.category.application;


import com.jarl.artodo.category.domain.Category;
import lombok.Getter;

import java.util.UUID;

@Getter
public final class CategoryResponse {
    private final String id;
    private final String name;
    private final String description;
    private final String emoji;

    public CategoryResponse(UUID id, String name, String description, String emoji) {
        this.id = id.toString();
        this.name = name;
        this.description = description;
        this.emoji = emoji;
    }

    public static CategoryResponse fromAggregate(Category category) {
        return new CategoryResponse(
            category.getId().value(),
            category.getName().value(),
            category.getDescription().value(),
            category.getEmoji().value()
        );
    }

}

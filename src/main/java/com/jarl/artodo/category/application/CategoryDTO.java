package com.jarl.artodo.category.application;


import com.jarl.artodo.category.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDTO {
    private String id;
    private String name;
    private String description;
    private String emoji;

    public CategoryDTO(String id, String name, String description, String emoji) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.emoji = emoji;
    }

    public static CategoryDTO mapperCategoryDTO(Category category) {
        return new CategoryDTO(
            category.getId().toString(),
            category.getName().value(),
            category.getDescription().value(),
            category.getEmoji().value()
        );
    }
}

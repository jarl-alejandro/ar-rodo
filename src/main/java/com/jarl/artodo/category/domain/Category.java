package com.jarl.artodo.category.domain;

import lombok.Getter;

@Getter
public final class Category {
    private final CategoryId id;
    private final CategoryName name;
    private final CategoryDescription description;
    private final CategoryEmoji emoji;

    public Category(CategoryId id, CategoryName name, CategoryDescription description, CategoryEmoji emoji) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.emoji = emoji;
    }
    public Category () {
        this.id = null;
        this.name = null;
        this.description = null;
        this.emoji = null;
    }

    public static Category create(CategoryId id,
                                  CategoryName name,
                                  CategoryDescription description,
                                  CategoryEmoji emoji) {
        return new Category(id, name, description, emoji);
    }

}

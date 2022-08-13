package com.jarl.artodo.category.infrastructure.persistence.jpa;

import com.jarl.artodo.category.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "emoji")
    private String emoji;

    public CategoryEntity(String id, String name, String description, String emoji) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.emoji = emoji;
    }

    public static Category mapperToCategory (CategoryEntity categoryEntity) {
        return Category.create(
            new CategoryId(categoryEntity.getId()),
            new CategoryName(categoryEntity.getName()),
            new CategoryDescription(categoryEntity.getDescription()),
            new CategoryEmoji(categoryEntity.getEmoji())
        );
    }
}

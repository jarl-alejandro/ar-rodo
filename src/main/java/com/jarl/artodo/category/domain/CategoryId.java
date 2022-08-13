package com.jarl.artodo.category.domain;

import com.jarl.artodo.shared.domain.Identifier;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class CategoryId extends Identifier {

    public CategoryId(UUID value) {
        super(value);
    }

    public CategoryId(String value) {
        super(UUID.fromString(value));
    }

    public static CategoryId generateCategoryId() {
        return new CategoryId(UUID.randomUUID());
    }
}

package com.jarl.artodo.category.application;

import java.util.List;

public final class CategoriesResponse {
    private final List<CategoryResponse> categories;

    public CategoriesResponse(List<CategoryResponse> categories) {
        this.categories = categories;
    }

    public List<CategoryResponse> categories() {
        return categories;
    }
}


package com.StreamingApp.WildFlixMSH.services;

import com.StreamingApp.WildFlixMSH.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);

    List<Category> getAllCategories();

    Optional<Category> findById(Long id);
}


package com.StreamingApp.WildFlixMSH.services;

import com.StreamingApp.WildFlixMSH.models.Category;
import com.StreamingApp.WildFlixMSH.models.Section;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CategoryService {

    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);

    List<Category> getAllCategories();



    Category findById(Long id);


}

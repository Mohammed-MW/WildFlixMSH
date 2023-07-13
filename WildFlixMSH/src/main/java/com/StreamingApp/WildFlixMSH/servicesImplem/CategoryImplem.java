package com.StreamingApp.WildFlixMSH.servicesImplem;

import com.StreamingApp.WildFlixMSH.models.Category;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.models.Section;
import com.StreamingApp.WildFlixMSH.repositories.CategoryRepository;
import com.StreamingApp.WildFlixMSH.repositories.MovieRepository;
import com.StreamingApp.WildFlixMSH.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImplem implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    public CategoryImplem(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent())
            return category.get();
        else return null;

    }



    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setCategoriename(category.getCategoriename());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }



    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}


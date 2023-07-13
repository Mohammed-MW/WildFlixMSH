package com.StreamingApp.WildFlixMSH.controllers;

import com.StreamingApp.WildFlixMSH.models.Category;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.models.Section;
import com.StreamingApp.WildFlixMSH.repositories.CategoryRepository;
import com.StreamingApp.WildFlixMSH.services.CategoryService;
import com.StreamingApp.WildFlixMSH.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    MovieService movieService;;


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/admin/categorie")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/admin/categorie/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if (category!=null)
            return new  ResponseEntity<Category>(category, HttpStatus.OK);
        else
            return new ResponseEntity<String>("Categorie not found", HttpStatus.NOT_FOUND);
    }


    @PostMapping("/admin/categorie")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

        @PutMapping("/admin/categorie/{id}")
        public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory != null) {
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    @DeleteMapping("/admin/categorie/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

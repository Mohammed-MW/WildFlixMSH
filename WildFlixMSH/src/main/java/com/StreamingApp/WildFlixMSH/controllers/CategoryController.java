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
    MovieService movieService;


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

   /* @PutMapping("/admin/categorie/{id}")
    public Category addMovie(@PathVariable Long id, @RequestBody Map<String, Long> request ){
        Movie movieToAdd = movieService.getMovieById(request.get("movieId"));
        Category category = categoryService.findById(id);
        category.getMovie().add(movieToAdd);

        return categoryService.createCategory(category);
    }*/

    /*@PutMapping("/admin/categorie/{id}")
    public ResponseEntity<Category> addMovieToCategory(@PathVariable Long id, @RequestBody Map<String, Long> request) {
        Category category = categoryService.findById(id);
        if (category != null) {
            Long movieId = request.get("movieId");
            Movie movie = movieService.getMovieById(movieId);
            if (movie != null) {
                category.getMovie().add(movie);
                Category updatedCategory = categoryService.updateCategory(id, category);
                return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Le film n'est pas trouvé
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // La catégorie n'est pas trouvée
        }
    }*/



    @DeleteMapping("/admin/categorie/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

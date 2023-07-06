package com.StreamingApp.WildFlixMSH.controllers;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
@Autowired
    MovieService movieService;
    @PutMapping("/admin/movies")
    public Movie createMovie(@RequestBody Movie movie){
        movieService.createMovie(movie);
        return movie;
    }
    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
    @DeleteMapping("/admin/movies/{id}")
    public void deleteMovie(@PathVariable Long id){
    movieService.deleteMovie(id);
    }
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id).get() ;
    }

    @PostMapping("/admin/movies/{id}")
    public Optional<Movie> update(@PathVariable Long id, @RequestBody Movie movie){
        Movie movieToUpdate = movieService.getMovieById(id).get();
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDescription(movie.getDescription());
        /*movieToUpdate.setCategories(movie.getCategories());*/
        movieToUpdate.setUrl(movie.getUrl());
        movieToUpdate.setDateOfRelease(movie.getDateOfRelease());
        movieToUpdate.setIsPrivate(movie.getIsPrivate());
        return Optional.ofNullable(movieService.createMovie(movieToUpdate));
    }

}

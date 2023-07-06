package com.StreamingApp.WildFlixMSH.controllers;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
@Autowired
    MovieService movieService;
    @PostMapping("/admin/movies")
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
    public ResponseEntity<?> getMovieById(@PathVariable Long id){
        Movie movie = movieService.getMovieById(id);
        if (movie != null)
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        else
            return new ResponseEntity<String>("Movie not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/admin/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        Movie updatedMovie = movieService.updateMovie(id, movie);
        if (updatedMovie != null) {
            return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*@PostMapping("/admin/movies/{id}")
    public Optional<Movie> update(@PathVariable Long id, @RequestBody Movie movie){
        Movie movieToUpdate = movieService.getMovieById(id);
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDescription(movie.getDescription());
        /*movieToUpdate.setCategories(movie.getCategories());
        movieToUpdate.setUrl(movie.getUrl());
        movieToUpdate.setDateOfRelease(movie.getDateOfRelease());
        movieToUpdate.setIsPrivate(movie.getIsPrivate());
        return Optional.ofNullable(movieService.createMovie(movieToUpdate));
    }*/

}

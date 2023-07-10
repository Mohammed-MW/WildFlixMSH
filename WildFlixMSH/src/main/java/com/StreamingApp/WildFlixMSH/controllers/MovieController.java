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
    public Movie getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id).get() ;
    }

    @PutMapping("/admin/movies/{id}")
    public ResponseEntity<Movie>  update(@PathVariable Long id, @RequestBody Movie movie){
        Movie updatedMovie = movieService.updateMovie(id,movie);
        if (updatedMovie != null) {
            return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

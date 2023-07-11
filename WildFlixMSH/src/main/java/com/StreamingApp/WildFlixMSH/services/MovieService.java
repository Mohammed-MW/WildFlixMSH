package com.StreamingApp.WildFlixMSH.services;
import com.StreamingApp.WildFlixMSH.models.Movie;
import java.util.List;

public interface MovieService {
    Movie createMovie (Movie movie);
    Movie getMovieById(Long id);
    List<Movie> getAllMovies();
    void deleteMovie (Long id);


    Movie updateMovie(Long id, Movie movie);

    /*void addCategoryToMovie (String title, CategoryName categoriename);*/



}

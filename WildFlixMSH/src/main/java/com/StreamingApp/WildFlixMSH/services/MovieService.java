
package com.StreamingApp.WildFlixMSH.services;
import com.StreamingApp.WildFlixMSH.models.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie createMovie (Movie movie);
    Movie updateMovie(Long id, Movie movie);
    Optional<Movie> getMovieById(Long id);
    List<Movie> getAllMovies();
    void deleteMovie (Long id);

}


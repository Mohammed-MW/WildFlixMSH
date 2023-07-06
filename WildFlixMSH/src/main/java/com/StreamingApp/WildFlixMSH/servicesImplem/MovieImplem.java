package com.StreamingApp.WildFlixMSH.servicesImplem;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.repositories.MovieRepository;
import com.StreamingApp.WildFlixMSH.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieImplem implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

}

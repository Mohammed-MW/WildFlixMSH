package com.StreamingApp.WildFlixMSH.servicesImplem;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.repositories.MovieRepository;
import com.StreamingApp.WildFlixMSH.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
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

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie movieToUpdate = movieRepository.findById(id).get();
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDescription(movie.getDescription());
        movieToUpdate.setCategories(movie.getCategories());
        movieToUpdate.setUrl(movie.getUrl());
        movieToUpdate.setDateOfRelease(movie.getDateOfRelease());
        movieToUpdate.setIsPrivate(movie.getIsPrivate());
        return movieToUpdate;
    }

}

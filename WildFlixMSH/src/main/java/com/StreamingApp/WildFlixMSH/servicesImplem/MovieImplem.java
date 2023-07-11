package com.StreamingApp.WildFlixMSH.servicesImplem;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.repositories.CategoryRepository;
import com.StreamingApp.WildFlixMSH.repositories.MovieRepository;
import com.StreamingApp.WildFlixMSH.services.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class MovieImplem implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent())
            return movie.get();
        else return null;
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
        Movie existingMovie = movieRepository.findById(id).orElse(null);
        if(existingMovie != null) {
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setDescription(movie.getDescription());
            existingMovie.setDateOfRelease(movie.getDateOfRelease());
            existingMovie.setUrl(movie.getUrl());
            existingMovie.setIsPrivate(movie.getIsPrivate());
            return existingMovie;
        }
        return null;
    }

   /* @Override
    public void addCategoryToMovie(String title, CategoryName categoryName) {
        Optional<Category> category = categoryRepository.findByName(categoryName);
        Optional<Movie> movie = movieRepository.findByTitle(title);

        if (category.isPresent() && movie.isPresent()){
            movie.get().getCategories().add(movie.get());
        }
    }*/


}

package com.StreamingApp.WildFlixMSH.repositories;

import com.StreamingApp.WildFlixMSH.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie save (Movie movie);
    Optional<Movie> findById(Long id);
    List<Movie> findAll();
    void deleteById(Long id);
}


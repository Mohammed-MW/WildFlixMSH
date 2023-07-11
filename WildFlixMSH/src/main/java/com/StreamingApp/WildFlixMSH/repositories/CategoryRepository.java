package com.StreamingApp.WildFlixMSH.repositories;

import com.StreamingApp.WildFlixMSH.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);


}

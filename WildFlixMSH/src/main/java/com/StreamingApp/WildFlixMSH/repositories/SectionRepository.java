package com.StreamingApp.WildFlixMSH.repositories;

import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SectionRepository extends JpaRepository <Section, Long> {
    Section save(Section section);
    Optional<Section> findById(Long id);
    List<Section> findAll();
    void deleteById(Long id);


}

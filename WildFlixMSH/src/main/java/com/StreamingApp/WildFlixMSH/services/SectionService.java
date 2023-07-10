package com.StreamingApp.WildFlixMSH.services;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.models.Section;
import java.util.List;
import java.util.Optional;


public interface SectionService {
    Section createSection (Section section);
    Section updateSection(Long id, Section section);
    Optional<Section> getSectionById(Long id);
    List<Section> getAllSections();
    void deleteSection (Long id);

}

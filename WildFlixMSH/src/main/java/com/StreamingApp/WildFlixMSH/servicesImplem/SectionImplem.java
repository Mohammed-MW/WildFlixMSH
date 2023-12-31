/*
package com.StreamingApp.WildFlixMSH.servicesImplem;
import com.StreamingApp.WildFlixMSH.models.Section;
import com.StreamingApp.WildFlixMSH.repositories.SectionRepository;
import com.StreamingApp.WildFlixMSH.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionImplem implements SectionService {
    @Autowired
    SectionRepository sectionRepository;
    @Override
    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Optional<Section> getSectionById(Long id) {
        return sectionRepository.findById(id);
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);

    }
}
*/

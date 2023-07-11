package com.StreamingApp.WildFlixMSH.controllers;
import com.StreamingApp.WildFlixMSH.models.Movie;
import com.StreamingApp.WildFlixMSH.models.Section;
import com.StreamingApp.WildFlixMSH.services.MovieService;
import com.StreamingApp.WildFlixMSH.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class    SectionController {
    @Autowired
    SectionService sectionService;

    @Autowired
    MovieService movieService;
    @PostMapping("/admin/sections")
    public Section createSection(@RequestBody Section section){
        sectionService.createSection(section);
        return section;
    }
    @GetMapping("/sections")
    public List<Section> getAllSections(){
        return sectionService.getAllSections();
    }
    @DeleteMapping("/admin/sections/{id}")
    public void deleteSection(@PathVariable Long id){
        sectionService.deleteSection(id);
    }
    @GetMapping("/sections/{id}")
    public Section getSectionById(@PathVariable Long id){
        return sectionService.getSectionById(id).get();

    }
    @PutMapping("/admin/sections/{id}")
    public Optional<Section> update(@PathVariable Long id, @RequestBody Section section){
        Section sectionToUpdate = sectionService.getSectionById(id).get();
        sectionToUpdate.setTitle(section.getTitle());
        sectionToUpdate.setDescription(section.getDescription());
        sectionToUpdate.setMovies(section.getMovies());
        return Optional.ofNullable(sectionService.createSection(sectionToUpdate));
    }

    @PutMapping("/sections/addMovie/{id}")
    public Optional<Section> addMovie(@PathVariable Long id, @RequestBody Map<String, Long> request ){
        Movie movieToAdd = movieService.getMovieById(request.get("movieId"));
        Section section = sectionService.getSectionById(id).get();
        section.getMovies().add(movieToAdd);

        return Optional.ofNullable(sectionService.createSection(section));
    }
}

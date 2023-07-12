package com.StreamingApp.WildFlixMSH.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;


    @ManyToMany
    @JoinTable(name= "section_movie",
        joinColumns = @JoinColumn(name="section_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies =new ArrayList<>();





}


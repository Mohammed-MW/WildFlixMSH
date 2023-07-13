package com.StreamingApp.WildFlixMSH.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    private String title;
    private String description;
    private Date dateOfRelease;
    private String url;
    private Boolean isPrivate;


    /*@ManyToMany
    @JoinTable(name="movie_categorie",
            joinColumns = @JoinColumn ( name="movie_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Category> categories = new ArrayList<>();*/
    @JsonIgnoreProperties("movie")
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "movie_categorie",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "categorie_id") })
    private List<Category> categories = new ArrayList<>();




}

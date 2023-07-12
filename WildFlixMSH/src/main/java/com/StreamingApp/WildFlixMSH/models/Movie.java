package com.StreamingApp.WildFlixMSH.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private Date dateOfRelease;
    private String url;
    private Boolean isPrivate;

/*private  Teaser teaser;*/


    @ManyToMany
    @JoinTable(name="movie_categorie",
            joinColumns = @JoinColumn ( name="movie_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Category> categories = new ArrayList<>();



/* Coté mohammed
    @ManyToMany(mappedBy = "categories")
    private List<Movie> movies = new ArrayList<>();*/


}


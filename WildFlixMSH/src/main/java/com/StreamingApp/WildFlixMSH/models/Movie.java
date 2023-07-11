package com.StreamingApp.WildFlixMSH.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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


    @ManyToMany
    @JoinTable(name="movie_categorie",
            joinColumns = @JoinColumn ( name="movie_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Category> categories = new ArrayList<>();



}

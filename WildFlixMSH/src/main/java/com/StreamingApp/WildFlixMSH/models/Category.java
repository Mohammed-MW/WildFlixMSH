package com.StreamingApp.WildFlixMSH.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoriename;




    /*@ManyToMany(mappedBy = "categories")
    private List<Movie> movie = new ArrayList<>();*/
    /*@JsonIgnoreProperties("movie")*/
    @ManyToMany(mappedBy = "categories")
    private List<Movie> movie = new ArrayList<>();




}

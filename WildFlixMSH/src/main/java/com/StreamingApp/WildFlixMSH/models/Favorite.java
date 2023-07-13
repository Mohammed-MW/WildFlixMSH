package com.StreamingApp.WildFlixMSH.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

 /*   @ManyToOne
    private Video video;*/
}

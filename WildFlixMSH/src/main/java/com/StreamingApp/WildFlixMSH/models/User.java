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
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;

    private String LastName;

    private Date birthday;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany (fetch = FetchType.EAGER)

    @JoinTable(
            name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "role_id")
    }
    )
    List<Role> roles = new ArrayList<>();


}

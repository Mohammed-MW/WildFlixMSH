package com.StreamingApp.WildFlixMSH.controllers;

import com.StreamingApp.WildFlixMSH.models.User;
import com.StreamingApp.WildFlixMSH.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getAllUsers (){

        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("getUserName")
    public String getName (Authentication authentication){

        return authentication.getName();
    }

    @GetMapping("getRoles")
    public List<String> getRoles (Authentication authentication){
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority grantedAuthority :authentication.getAuthorities()){
            roles.add(grantedAuthority.getAuthority());
        }
        return roles;
    }
    @GetMapping("/{email}")
    User getUserByEmail (@PathVariable String email){

        return userService.getUserByEmail(email);
    }
    @PostMapping("/{userId}/favorites/{movieId}")
    public ResponseEntity<?> addFavorite(
            @PathVariable Long userId,
            @PathVariable Long movieId
    )
    {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));

//        movie video = movieService.getmovieById(movieId)
//                .orElseThrow(() -> new NotFoundException("Vidéo non trouvée"));

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setMovie(movie);
        favoriteRepository.save(favorite);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/favorites/{videoId}")
    public ResponseEntity<?> removeFavorite(
            @PathVariable Long userId,
            @PathVariable Long videoId
    ) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));

        Video video = videoService.getVideoById(videoId)
                .orElseThrow(() -> new NotFoundException("Vidéo non trouvée"));

        Favorite favorite = favoriteRepository.findByUserAndVideo(user, video)
                .orElseThrow(() -> new NotFoundException("Favori non trouvé"));

        favoriteRepository.delete(favorite);

        return ResponseEntity.ok().build();
    }

}

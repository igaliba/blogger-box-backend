package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.dto.CreationPostRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final List<Post> temporaryPosts = new ArrayList<>();

    public PostController() {
        // Un petit post par défaut pour tester
        temporaryPosts.add(new Post(1, "Bienvenue", "Ceci est mon premier post !", "Admin"));
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return temporaryPosts;
    }

    @PostMapping
    public Post createPost(@RequestBody CreationPostRequest request) {
        Integer newId = temporaryPosts.size() + 1;
        Post newPost = new Post(newId, request.getTitle(), request.getContent(), request.getAuthor());
        temporaryPosts.add(newPost);
        return newPost;
    }
}
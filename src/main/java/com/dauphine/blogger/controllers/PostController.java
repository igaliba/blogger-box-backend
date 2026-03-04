package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.dto.UpdatePostRequest;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam(required = false) UUID categoryId) {
        if (categoryId != null) {
            return service.getAllByCategoryId(categoryId);
        }
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody CreationPostRequest request) {
        return service.create(
                request.getTitle(),
                request.getContent(),
                request.getCategoryId(), // Assure-toi que ce champ existe dans ton DTO
                request.getAuthor()
        );
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody UpdatePostRequest request) {
        return service.update(id, request.getTitle(), request.getContent());
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
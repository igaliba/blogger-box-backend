package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return posts.stream()
                .filter(post -> categoryId.equals(post.getCategoryId()))
                .collect(Collectors.toList());
    }

    @Override
    public Post getById(UUID id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, UUID categoryId, String author) {
        Post post = new Post(UUID.randomUUID(), title, content, author, categoryId);
        posts.add(post);
        return post;
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = getById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
        }
        return post;
    }

    @Override
    public boolean deleteById(UUID id) {
        return posts.removeIf(post -> post.getId().equals(id));
    }
}
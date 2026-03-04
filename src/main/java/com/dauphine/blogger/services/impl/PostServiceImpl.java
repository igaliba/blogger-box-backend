package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.repositories.PostRepository;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    // Injection des deux repositories par constructeur
    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> getAll() {
        // Remplace posts.stream() par postRepository.findAll() [cite: 2513]
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        // On récupère tous les posts et on filtre par l'ID de la catégorie associée
        return postRepository.findAll().stream()
                .filter(post -> post.getCategory().getId().equals(categoryId))
                .toList();
    }

    @Override
    public Post getById(UUID id) {
        // Utilise findById du repository [cite: 2488-2489]
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post create(String title, String content, UUID categoryId) {
        // 1. On cherche la catégorie dans la base d'abord
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (category == null) {
            return null;
        }

        // 2. On crée le Post (le constructeur gère l'ID et la date) [cite: 2444-2452]
        Post post = new Post(title, content, category);

        // 3. On sauvegarde avec le repository [cite: 2492-2493]
        return postRepository.save(post);
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = getById(id);
        if (post == null) {
            return null;
        }
        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    @Override
    public boolean deleteById(UUID id) {
        postRepository.deleteById(id);
        return true;
    }
}
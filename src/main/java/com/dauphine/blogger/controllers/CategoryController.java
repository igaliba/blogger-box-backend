package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.models.Category; // Importe ta classe Category
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    // On crée une liste vide qui fera office de "base de données" temporaire
    private final List<Category> temporaryCategories = new ArrayList<>();

    // Le constructeur initialise la liste avec quelques exemples
    public CategoryController() {
        temporaryCategories.add(new Category(1, "Ma première catégorie"));
        temporaryCategories.add(new Category(2, "Ma deuxième catégorie"));
    }

    // On retourne maintenant la vraie liste au lieu d'un texte
    @GetMapping
    public List<Category> getAllCategories() {
        return temporaryCategories;
    }
    @PostMapping
    public Category createCategory(@RequestBody CreationCategoryRequest request) {
        // On crée un nouvel ID (taille de la liste + 1)
        Integer newId = temporaryCategories.size() + 1;

        // On crée la nouvelle catégorie à partir du nom reçu dans le DTO
        Category newCategory = new Category(newId, request.getName());

        // On l'ajoute à notre liste temporaire
        temporaryCategories.add(newCategory);

        return newCategory;
    }
}


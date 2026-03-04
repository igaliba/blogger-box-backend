package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException; // Import indispensable
import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();
    Category getById(UUID id) throws CategoryNotFoundByIdException;
    Category create(String name);
    Category updateName(UUID id, String name) throws CategoryNotFoundByIdException;
    boolean deleteById(UUID id);
    List<Category> getAllLikeName(String name);
}
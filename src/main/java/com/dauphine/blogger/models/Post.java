package com.dauphine.blogger.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private UUID id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private UUID categoryId; // Ajouté pour lier à une catégorie

    public Post() {}

    public Post(UUID id, String title, String content, String author, UUID categoryId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.categoryId = categoryId;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public UUID getCategoryId() { return categoryId; }
    public void setCategoryId(UUID categoryId) { this.categoryId = categoryId; }
}
package com.dauphine.blogger.models;

public class Category {
    private Integer id;
    private String name;

    // Constructeur vide (obligatoire pour Spring)
    public Category() {}

    // Constructeur complet
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters et Setters (clic droit -> Generate -> Getter and Setter)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
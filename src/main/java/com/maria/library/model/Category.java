package com.maria.library.model;


public class Category {
    Long id;
    String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(Long is, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

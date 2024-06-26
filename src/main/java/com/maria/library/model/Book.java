package com.maria.library.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Book {
    Long id;
    String title;
    Long publicationYear;
    Long clientId;
    Long categoryId;

    public Book(String title, Long publicationYear, Long categoryId) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.categoryId = categoryId;
    }

    public Book(Long id, String title, Long publicationYear, Long categoryId) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.categoryId = categoryId;
    }
}

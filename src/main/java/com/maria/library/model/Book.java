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

    public Book(String title, Long publicationYear, Long clientId, Long categoryId) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.clientId = clientId;
        this.categoryId = categoryId;
    }
}

package com.maria.library.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Author {
    Long id;
    String firstname;
    String lastname;
    Long numberOfBooks;

    public Author(String firstname, String lastname, Long numberOfBooks) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberOfBooks = numberOfBooks;
    }
}

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

    public Author(Long id, String firstname, String lastname, Long numberOfBooks) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberOfBooks = numberOfBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Long numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}

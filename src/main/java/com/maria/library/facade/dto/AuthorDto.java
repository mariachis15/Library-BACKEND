package com.maria.library.facade.dto;

public class AuthorDto {
    private String firstname;
    private String lastname;
    private Long numberOfBooks;

    public AuthorDto() {
    }

    public AuthorDto(String firstname, String lastname, Long numberOfBooks) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberOfBooks = numberOfBooks;
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

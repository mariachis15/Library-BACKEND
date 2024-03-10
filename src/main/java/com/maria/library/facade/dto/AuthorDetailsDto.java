package com.maria.library.facade.dto;

public class AuthorDetailsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long numberOfBooks;

    public AuthorDetailsDto() {
    }

    public AuthorDetailsDto(Long id, String firstName, String lastName, Long numberOfBooks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfBooks = numberOfBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Long numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}

package com.maria.library.facade.dto;

public class BookDetailsDto {
    private Long id;
    private String title;
    private Long publicationYear;
    private String category;
    private String author;

    public BookDetailsDto() {
    }

    public BookDetailsDto(Long id, String title, Long publicationYear, String category, String author) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Long publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

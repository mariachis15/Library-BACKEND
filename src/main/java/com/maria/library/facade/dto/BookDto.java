package com.maria.library.facade.dto;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private Long publicationYear;
    private Long categoryId;
    private Long authorId;
}

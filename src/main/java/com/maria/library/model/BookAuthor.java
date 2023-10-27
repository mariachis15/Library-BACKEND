package com.maria.library.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class BookAuthor {
    Long bookId;
    Long authorId;

    public BookAuthor(Long bookId, Long authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }
}

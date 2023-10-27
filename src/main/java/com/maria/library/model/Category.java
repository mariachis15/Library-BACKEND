package com.maria.library.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Category {
    Long id;
    String name;

    public Category(String name) {
        this.name = name;
    }
}

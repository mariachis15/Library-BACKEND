package com.maria.library.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role {
    Long id;
    String name;

    public Role(String name) {
        this.name = name;
    }
}

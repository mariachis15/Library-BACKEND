package com.maria.library.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserData {
    Long id;
    String username;
    String passwordUser;
    String firstname;
    String lastname;
    Long roleId;

    public UserData(String username, String passwordUser, String firstname, String lastname, Long roleId) {
        this.username = username;
        this.passwordUser = passwordUser;
        this.firstname = firstname;
        this.lastname = lastname;
        this.roleId = roleId;
    }
}

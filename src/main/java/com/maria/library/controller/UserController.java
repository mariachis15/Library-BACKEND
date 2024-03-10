package com.maria.library.controller;

import com.maria.library.common.Response;
import com.maria.library.facade.IUserFacade;
import com.maria.library.facade.dto.UserDto;
import com.maria.library.model.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserFacade userFacade;

    public UserController(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public ResponseEntity<Response<List<UserDto>>> getAllUsers() {
        Response<List<UserDto>> response = userFacade.getAllUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.maria.library.controller;

import com.maria.library.facade.IAuthenticationFacade;
import com.maria.library.facade.dto.RegisterDto;
import com.maria.library.facade.implementation.AuthenticationFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    private final IAuthenticationFacade authenticationFacade;

    public AuthenticationController(AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegisterDto registerDto) {
        authenticationFacade.addUser(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

package com.maria.library.controller;

import com.maria.library.common.Response;
import com.maria.library.facade.IRoleFacade;
import com.maria.library.model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final IRoleFacade roleFacade;

    public RoleController(IRoleFacade roleFacade) {
        this.roleFacade = roleFacade;
    }

    @GetMapping
    public ResponseEntity<Response<List<Role>>> getAllRoles() {
        Response<List<Role>> response = roleFacade.getAllRoles();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

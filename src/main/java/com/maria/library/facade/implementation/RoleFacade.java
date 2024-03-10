package com.maria.library.facade.implementation;

import com.maria.library.common.Response;
import com.maria.library.facade.IRoleFacade;
import com.maria.library.model.Role;
import com.maria.library.service.IRoleService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleFacade implements IRoleFacade {
    private final IRoleService roleService;

    public RoleFacade(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Response<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAll();
        return new Response<>(roles);
    }
}

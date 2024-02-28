package com.maria.library.facade.implementation;

import com.maria.library.facade.IAuthenticationFacade;
import com.maria.library.facade.dto.RegisterDto;
import com.maria.library.facade.mapper.UserMapper;
import com.maria.library.model.UserData;
import com.maria.library.service.IRoleService;
import com.maria.library.service.IUserDataService;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
    private final IRoleService roleService;
    private final IUserDataService userService;
    private final UserMapper userMapper;

    public AuthenticationFacade(IRoleService roleService, IUserDataService userService, UserMapper userMapper) {
        this.roleService = roleService;
        this.userService = userService;
        this.userMapper = userMapper;

    }
    public void addUser(RegisterDto registerDto) {
        Long roleId = roleService.getIdByName(registerDto.getRole());
        UserData user = userMapper.mapToEntity(registerDto, roleId);
        userService.save(user);
    }

}

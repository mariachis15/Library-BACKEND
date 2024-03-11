package com.maria.library.facade.implementation;

import com.maria.library.common.Response;
import com.maria.library.facade.IUserFacade;
import com.maria.library.facade.dto.UserDto;
import com.maria.library.facade.mapper.UserMapper;
import com.maria.library.model.Role;
import com.maria.library.model.UserData;
import com.maria.library.service.IRoleService;
import com.maria.library.service.IUserDataService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacade implements IUserFacade {
    private final UserMapper userMapper;
    private final IUserDataService userService;
    private final IRoleService roleService;

    public UserFacade(UserMapper userMapper, IUserDataService userService, IRoleService roleService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public Response<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<UserData> users = userService.getAll();

        for (var user : users) {
            Role role = roleService.getById(user.getRoleId());
            UserDto userDto = userMapper.mapToUserDto(user, role.getName());
            userDtoList.add(userDto);
        }
        return new Response<>(userDtoList);
    }

    @Override
    public void deleteUser(Long id) {
        userService.delete(id);
    }
}

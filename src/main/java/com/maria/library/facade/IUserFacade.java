package com.maria.library.facade;

import com.maria.library.common.Response;
import com.maria.library.facade.dto.UserDto;

import java.util.List;

public interface IUserFacade {
    Response<List<UserDto>> getAllUsers();

    void deleteUser(Long id);

    void updateUser(Long id, UserDto userDto);
}

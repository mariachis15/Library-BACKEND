package com.maria.library.facade.mapper;

import com.maria.library.facade.dto.RegisterDto;
import com.maria.library.facade.dto.UserDto;
import com.maria.library.model.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserData mapToEntity(RegisterDto registerDto, Long roleId) {
        UserData userData = new UserData(registerDto.getUsername(), registerDto.getPassword(), registerDto.getFirstName(), registerDto.getLastName(), roleId);
        return userData;
    }

    public UserDto mapToUserDto(UserData user, String role) {
        UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname(), role);
        return userDto;
    }

}

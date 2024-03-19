package com.maria.library.facade.mapper;

import com.maria.library.facade.dto.RegisterDto;
import com.maria.library.facade.dto.UserDto;
import com.maria.library.model.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserData mapToEntity(RegisterDto registerDto, Long roleId) {
        return new UserData(registerDto.getUsername(), registerDto.getPassword(), registerDto.getFirstName(), registerDto.getLastName(), roleId);
    }

    public UserDto mapToUserDto(UserData user) {
        return new UserDto(user.getId(), user.getUsername(), user.getPasswordUser(), user.getFirstname(), user.getLastname(), user.getRoleId());
    }

    public UserData mapToEntity(Long id, UserDto userDto) {
        return  new UserData(id,userDto.getUsername(), userDto.getPassword(), userDto.getFirstname(), userDto.getLastname(), userDto.getRoleId());
    }

}

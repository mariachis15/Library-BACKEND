package com.maria.library.facade;

import com.maria.library.facade.dto.RegisterDto;

public interface IAuthenticationFacade {
    void addUser(RegisterDto registerDto);
}

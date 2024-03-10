package com.maria.library.facade;

import com.maria.library.common.Response;
import com.maria.library.model.Role;

import java.util.List;

public interface IRoleFacade {
    Response<List<Role>> getAllRoles();
}

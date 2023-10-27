package com.maria.library.service.implementation;

import com.maria.library.exceptions.RoleNotFoundException;
import com.maria.library.model.Role;
import com.maria.library.repository.IRoleRepository;
import com.maria.library.repository.implementation.RoleRepository;
import com.maria.library.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.read();
    }

    @Override
    public Optional<Role> getById(Long id) {
        Optional<Role> role = roleRepository.readById(id);
        if (role.isEmpty()) {
            throw new RoleNotFoundException("The role does not exist.");
        }
        return role;
    }

    @Override
    public void save(Role role) {
        roleRepository.create(role);
    }

    @Override
    public void update(Role role) {
        int changedRows = roleRepository.update(role);
        if (changedRows == 0) {
            throw new RoleNotFoundException("The role does not exist.");
        }
    }

    @Override
    public void delete(Long id) {
        roleRepository.delete(id);

    }
}

package com.maria.library.service.implementation;

import com.maria.library.exceptions.UserNotFoundException;
import com.maria.library.model.UserData;
import com.maria.library.repository.IUserDataRepository;
import com.maria.library.repository.implementation.UserDataRepository;
import com.maria.library.service.IUserDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService implements IUserDataService {
    private IUserDataRepository userDataRepository;

    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    @Override
    public List<UserData> getAll() {
        return userDataRepository.read();
    }

    @Override
    public Optional<UserData> getById(Long id) {
        Optional<UserData> userData = userDataRepository.readById(id);
        if (userData.isEmpty()) {
            throw new UserNotFoundException("The user does not exist.");
        }
        return userData;
    }

    @Override
    public void save(UserData userData) {
        userDataRepository.create(userData);
    }

    @Override
    public void update(UserData userData) {
        int changedRows = userDataRepository.update(userData);
        if (changedRows == 0) {
            throw new UserNotFoundException("The user does not exist.");
        }
    }

    @Override
    public void delete(Long id) {
        userDataRepository.delete(id);
    }
}

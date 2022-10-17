package com.crudOperations.service;

import com.crudOperations.dto.CreateUserDto;
import com.crudOperations.dto.UpdateUserDto;
import com.crudOperations.model.User;

public interface UserService {
    CreateUserDto create(User user);
    UpdateUserDto update(Long id, User user);
    UpdateUserDto partialUpdate(Long id, User user);
    void delete(Long id);
}

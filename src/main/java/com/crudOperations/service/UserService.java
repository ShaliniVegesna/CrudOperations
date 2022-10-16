package com.crudOperations.service;

import com.crudOperations.model.User;

public interface UserService {
    User create(User user);
    User update(Long id, User user);
    User partialUpdate(Long id, User user);
    void delete(Long id);
}

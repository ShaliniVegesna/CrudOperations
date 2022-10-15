package com.crudOperations.service;

import com.crudOperations.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> create(User user);
    ResponseEntity<Object> update(Long id, User user);
    ResponseEntity<Object> partialUpdate(Long id, User user);
    ResponseEntity<Object> delete(Long id);
}

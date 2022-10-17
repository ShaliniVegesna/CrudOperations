package com.crudOperations.controller;

import com.crudOperations.exception.UserAlreadyExistsException;
import com.crudOperations.exception.UserNotFoundException;
import com.crudOperations.model.User;
import com.crudOperations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User user) throws UserAlreadyExistsException {
          return new ResponseEntity<>(userService.create(user),HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user) throws UserNotFoundException {
        return new ResponseEntity<>(userService.update(id,user),HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable Long id,@RequestBody User user) throws UserNotFoundException{
        return new ResponseEntity<>(userService.partialUpdate(id,user),HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws UserNotFoundException{
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

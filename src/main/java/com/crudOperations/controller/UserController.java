package com.crudOperations.controller;

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
    public ResponseEntity<Object> create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id,user);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<Object> partialUpdate(@PathVariable Long id,@RequestBody User user) { return userService.partialUpdate(id,user);}

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}

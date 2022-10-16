package com.crudOperations.controller;

import com.crudOperations.model.User;
import com.crudOperations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/users")
    public ResponseEntity<Object> create(@RequestBody User user) {
          userService.create(user);
          Map<String, Object> responseMap = new HashMap<>();
          responseMap.put("name", user.getName());
          responseMap.put("job", user.getJob());
          responseMap.put("id",user.getId());
          responseMap.put("createdAt", LocalDateTime.now());
          return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody User user) {
        userService.update(id,user);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("name", user.getName());
        responseMap.put("job", user.getJob());
        responseMap.put("updatedAt",LocalDateTime.now());
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<Object> partialUpdate(@PathVariable Long id,@RequestBody User user) {
        userService.partialUpdate(id,user);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("name", user.getName());
        responseMap.put("job", user.getJob());
        responseMap.put("updatedAt",LocalDateTime.now());
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

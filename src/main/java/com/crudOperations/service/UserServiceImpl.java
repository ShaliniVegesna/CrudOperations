package com.crudOperations.service;

import com.crudOperations.model.User;
import com.crudOperations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<Object> create(User user) {
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("name", user.getName());
        responseMap.put("job", user.getJob());
        responseMap.put("id",user.getId());
        responseMap.put("createdAt",LocalDateTime.now());
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> update(Long id, User user) {
        user.setUpdatedAt(LocalDateTime.now());
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("name", user.getName());
        responseMap.put("job", user.getJob());
        responseMap.put("updatedAt",LocalDateTime.now());
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> partialUpdate(Long id, User user) {
        user.setUpdatedAt(LocalDateTime.now());
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("name", user.getName());
        responseMap.put("job", user.getJob());
        responseMap.put("updatedAt",LocalDateTime.now());
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

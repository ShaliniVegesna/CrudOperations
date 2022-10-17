package com.crudOperations.service;

import com.crudOperations.dto.CreateUserDto;
import com.crudOperations.dto.UpdateUserDto;
import com.crudOperations.exception.UserNotFoundException;
import com.crudOperations.model.User;
import com.crudOperations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public CreateUserDto create(User user) {
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return new CreateUserDto(user.getId(),user.getName(),user.getJob(),user.getCreatedAt());
    }

    @Override
    public UpdateUserDto update(Long id, User user) {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return new UpdateUserDto(user.getName(),user.getJob(),user.getUpdatedAt());
    }

    @Override
    public UpdateUserDto partialUpdate(Long id, User user) {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return new UpdateUserDto(user.getName(),user.getJob(),user.getUpdatedAt());
    }

    @Override
    public void delete(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        userRepository.deleteById(id);
    }
}

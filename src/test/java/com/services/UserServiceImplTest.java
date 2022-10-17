package com.services;

import com.crudOperations.dto.CreateUserDto;
import com.crudOperations.model.User;
import com.crudOperations.repository.UserRepository;
import com.crudOperations.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testCreate(){
        User user =new User();
        LocalDateTime createdDate = LocalDateTime.now();
        user.setId(1L);
        user.setName("morpheus");
        user.setJob("leader");
        User createdUser = new User();
        createdUser.setId(1L);
        createdUser.setName("morpheus");
        createdUser.setJob("leader");
        createdUser.setCreatedAt(createdDate);
        Mockito.when(userRepository.save(user)).thenReturn(createdUser);
        Assertions.assertEquals(userService.create(user).getId(),1L);
        Assertions.assertEquals(userService.create(user).getName(),"morpheus");
        Assertions.assertEquals(userService.create(user).getJob(),"leader");
        Assertions.assertEquals(userService.create(user).getCreatedAt().toLocalDate(),createdDate.toLocalDate());
    }
    @Test
    public void testUpdate(){
        User user =new User();
        LocalDateTime updatedDate = LocalDateTime.now();
        user.setId(1L);
        user.setName("morpheus");
        user.setJob("zion resident");
        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setName("morpheus");
        updatedUser.setJob("leader");
        updatedUser.setCreatedAt(updatedDate);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(userService.update(user.getId(),user).getName(),"morpheus");
        Assertions.assertEquals(userService.update(user.getId(),user).getJob(),"zion resident");
        Assertions.assertEquals(userService.update(user.getId(),user).getUpdatedAt().toLocalDate(),updatedDate.toLocalDate());
    }
    @Test
    public void testPartialUpdate(){
        User user =new User();
        LocalDateTime updatedDate = LocalDateTime.now();
        user.setId(1L);
        user.setName("morpheus");
        user.setJob("zion");
        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setName("morpheus");
        updatedUser.setJob("leader");
        updatedUser.setCreatedAt(updatedDate);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(userService.partialUpdate(user.getId(),user).getName(),"morpheus");
        Assertions.assertEquals(userService.partialUpdate(user.getId(),user).getJob(),"zion");
        Assertions.assertEquals(userService.partialUpdate(user.getId(),user).getUpdatedAt().toLocalDate(),updatedDate.toLocalDate());
    }
}
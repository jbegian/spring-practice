package com.exercise.springpractice.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import com.exercise.springpractice.model.User;
import com.exercise.springpractice.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @Mock
    UserRepository userRepository;
    
    @InjectMocks
    UserService userService;

    @BeforeEach
    void initializeMockData() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    @DisplayName("Testing - Find All Users")
    void findAllUsersTest() {

        Iterable<User> users = Arrays.asList(User.builder().id(1).name("name").email("email").build(),
                User.builder().id(2).name("name").email("email").build());

        when(userRepository.findAll()).thenReturn(users);
        assertAll(
            () -> assertEquals(2, userService.findAllUsers().size()),
            () -> verify(userRepository, times(1)).findAll());
    }
    
    @Test
    @DisplayName("Testing - Create User")
    void createUserTest() {
        User expectedUser = User.builder().id(1).name("name").email("email").build();
        when(userRepository.save(any(User.class))).thenReturn(expectedUser);
        User actualUser = userService.createUser(User.builder().name("name").email("email").build());

        assertAll(
            () -> assertEquals(expectedUser.getName(), actualUser.getName()),
            () -> assertEquals(expectedUser.getEmail(), actualUser.getEmail()),
            () -> verify(userRepository, times(1)).save(any(User.class)));
    }
}

package com.example.SpringTestDemo.service;

import com.example.SpringTestDemo.model.User;
import com.example.SpringTestDemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testGetUserById_ReturnsUser() {
        // Arrange
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("John");

        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        // Act
        User result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    public void testGetUserById_NotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        User result = userService.getUserById(2L);

        assertNull(result);
    }
}

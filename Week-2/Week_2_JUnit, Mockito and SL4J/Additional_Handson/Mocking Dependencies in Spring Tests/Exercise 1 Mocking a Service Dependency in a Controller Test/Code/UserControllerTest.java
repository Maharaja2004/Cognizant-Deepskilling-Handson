package com.example;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	 @Mock
	    private UserService userService;

	    @InjectMocks
	    private UserController userController;

	    @Test
	    public void testGetUser() {
	       
	        User mockUser = new User();
	        mockUser.setId(1L);
	        mockUser.setName("John");

	        when(userService.getUserById(1L)).thenReturn(mockUser);

	     
	        ResponseEntity<User> response = userController.getUser(1L);

	        
	        assertEquals(200, response.getStatusCodeValue());
	        assertEquals("John", response.getBody().getName());
	    }
}

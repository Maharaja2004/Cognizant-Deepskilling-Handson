package com.example;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService; // Mocking service, not controller

    @Test
    public void testGetUserById() throws Exception {
        // Prepare mock data
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("John");

        // Stub service call
        when(userService.getUserById(1L)).thenReturn(mockUser);

        // Perform GET /users/1 and verify response
        mockMvc.perform(get("/users/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.name").value("John"));
    }
}

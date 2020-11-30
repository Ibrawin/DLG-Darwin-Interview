package com.ibrawin.api.webmvcapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibrawin.api.webmvcapi.model.User;
import com.ibrawin.api.webmvcapi.service.UserService;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {


    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        userService = Mockito.mock(UserService.class);
        userController = new UserController(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test
    void getAllUsers() throws Exception {
        List<User> userList = Arrays.asList(new User(), new User(), new User());
        when(userService.findAllUsers()).thenReturn(userList);

        mockMvc.perform(get(UserController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void getUserByIdSuccess() throws Exception {
        User user = new User();
        user.setId(1L);
        when(userService.findUserById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get(UserController.BASE_URL + "/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1L)));
    }

    @Test
    void getUserByIdFailure() throws Exception {
        when(userService.findUserById(1L)).thenThrow(NotFoundException.class);

        mockMvc.perform(get(UserController.BASE_URL + "/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    void newUser() throws Exception {
        User user = new User();
        user.setFullName("Ibrahim Ayanbunmi");

        when(userService.saveUser(Mockito.any())).thenReturn(user);
        String asJsonString = new ObjectMapper().writeValueAsString(user);
        mockMvc.perform(post(UserController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.fullName", equalTo("Ibrahim Ayanbunmi")));
    }

    @Test
    void removeUser() throws Exception {
        mockMvc.perform(delete(UserController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService).deleteUserById(anyLong());
    }
}
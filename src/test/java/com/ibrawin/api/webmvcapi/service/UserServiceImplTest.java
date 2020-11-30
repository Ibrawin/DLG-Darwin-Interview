package com.ibrawin.api.webmvcapi.service;

import com.ibrawin.api.webmvcapi.model.User;
import com.ibrawin.api.webmvcapi.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void findUserByIdSuccess() {
        User user = new User();
        user.setId(1L);
        user.setFullName("Ibrahim Ayanbunmi");
        user.setEmail("ibrahim-ayanbunmi@live.co.uk");
        user.setPassword("12345");
        user.setPhoneNumber("07718136436");
        user.setDepartment("Engineer");
        user.setJobTitle("Software Engineer");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> returnedUser = userService.findUserById(1L);

        Assertions.assertEquals(user, returnedUser.get());
        Assertions.assertTrue(returnedUser.isPresent());
    }

    @Test
    public void findUserByIdFailure() {

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<User> returnedUser = userService.findUserById(1L);

        Assertions.assertFalse(returnedUser.isPresent());
    }

    @Test
    public void findAllUsers() {
        User user1 = new User();
        user1.setId(1L);
        user1.setFullName("Ibrahim Ayanbunmi");
        user1.setEmail("ibrahim-ayanbunmi@live.co.uk");
        user1.setPassword("12345");
        user1.setPhoneNumber("07718136436");
        user1.setDepartment("Engineer");
        user1.setJobTitle("Software Engineer");

        User user2 = new User();
        user2.setId(2L);
        user2.setFullName("John Doe");
        user2.setEmail("aaaaa-bbbbb@live.co.uk");
        user2.setPassword("67890");
        user2.setPhoneNumber("01234567890");
        user2.setDepartment("Business");
        user2.setJobTitle("Business Analyst");

        List<User> userList = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> returnedUserList = userService.findAllUsers();

        Assertions.assertEquals(2, returnedUserList.size());
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setId(1L);
        user.setFullName("Ibrahim Ayanbunmi");
        user.setEmail("ibrahim-ayanbunmi@live.co.uk");
        user.setPassword("12345");
        user.setPhoneNumber("07718136436");
        user.setDepartment("Engineer");
        user.setJobTitle("Software Engineer");

        when(userRepository.save(Mockito.any())).thenReturn(user);

        User returnedUser = userService.saveUser(user);

        Assertions.assertNotNull(returnedUser);
    }

    @Test
    public void deleteUserById() {

        userRepository.deleteById(1L);

        verify(userRepository, times(1)).deleteById(anyLong());
    }
}
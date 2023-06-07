package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.Ingredient;
import com.project.fooddeliveryapp.model.Restaurant;
import com.project.fooddeliveryapp.model.User;
import com.project.fooddeliveryapp.repository.IngredientRepository;
import com.project.fooddeliveryapp.repository.RestaurantRepository;
import com.project.fooddeliveryapp.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("Create user")
    public void UserShouldSucceed() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setLastName("Neacsu");
        user.setPassword("Parola123");
        user.setUsername("marianeacsu");
        when(userRepository.save(user)).thenReturn(user);
        User result = userService.saveUser(user);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(user.getUsername(), result.getUsername());
    }

    @Test
    @DisplayName("Get all users")
    public void getAllUsersShouldSucceed() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setLastName("Neacsu");
        user.setPassword("Parola123");
        user.setUsername("marianeacsu");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        List<User> results = userService.getAllUsers();
        assertEquals(userList.size(), results.size());
    }

    @Test
    @DisplayName("Delete one user")
    public void deleteUserShouldWork() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setLastName("Neacsu");
        user.setPassword("Parola123");
        user.setUsername("marianeacsu");
        userService.deleteUserById(user.getId());
        verify(userRepository, times(1)).deleteById(user.getId());
    }

    @Test
    @DisplayName("Get one user")
    public void getUserShouldWork() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setLastName("Neacsu");
        user.setPassword("Parola123");
        user.setUsername("marianeacsu");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        userService.getUserById(user.getId());
        verify(userRepository, times(1)).findById(user.getId());
    }

}
package com.example.libman.service;

import com.example.libman.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
}

package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    private Utils utils;

    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString().split("-")[0]);
        // TODO: add hashing to password
        String userPassword = user.getPassword();
        user.setPassword(utils.hashPassword(userPassword));
        user.setCreatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User getUserById(String id) {
        return repository.findById(id).get();
    }

    public User updateUser(User userRequest) {
        User existingUser = repository.findById(userRequest.getId()).get();
        existingUser.setPassword(userRequest.getPassword());
        existingUser.setEmail(userRequest.getEmail());
        return repository.save(existingUser);
    }

    public String deleteUser(String id) {
        repository.deleteById(id);
        return "user " + id + "deleted";
    }
}

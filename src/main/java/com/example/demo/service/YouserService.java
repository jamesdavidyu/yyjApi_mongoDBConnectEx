package com.example.demo.service;

import com.example.demo.model.Youser;
import com.example.demo.repository.YouserRepository;
import com.example.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class YouserService {

    @Autowired
    private YouserRepository repository;
    private Utils utils;

    public Youser addYouser(Youser youser) {
        youser.setId(UUID.randomUUID().toString().split("-")[0]);
        String userPassword = youser.getPassword();
        youser.setPassword(utils.hashPassword(userPassword));
        youser.setCreatedAt(LocalDateTime.now());
        return repository.save(youser);
    }

    public Youser getYouserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
}

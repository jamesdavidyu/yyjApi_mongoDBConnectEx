package com.example.demo.controller;

import com.example.demo.model.Youser;
import com.example.demo.service.YouserService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/login")
public class LoginController {

    @Autowired
    private YouserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getYouserByEmailAndPassword(@RequestBody String email, String password) {
        Youser foundYouser = service.getYouserByEmailAndPassword(email, password);
        if (foundYouser == null) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        } else {
            return null; // jwt token
        }
    }
}

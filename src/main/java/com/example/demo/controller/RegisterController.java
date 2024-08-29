package com.example.demo.controller;

import com.example.demo.model.Youser;
import com.example.demo.service.YouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/register")
public class RegisterController {

    @Autowired
    private YouserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Youser createYouser(@RequestBody Youser youser) {
        return service.addYouser(youser);
    }
}

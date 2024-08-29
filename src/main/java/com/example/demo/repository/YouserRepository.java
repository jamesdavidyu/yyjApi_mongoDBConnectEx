package com.example.demo.repository;

import com.example.demo.model.Youser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface YouserRepository extends MongoRepository<Youser, String> {
    Youser findByEmailAndPassword(String email, String password);
}

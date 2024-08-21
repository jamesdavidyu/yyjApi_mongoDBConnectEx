package com.example.demo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.ZonedDateTime;

@Data
@Document
public class User {
    private int id;
    private String email;
    private String password;
    private ZonedDateTime createdAt;
}

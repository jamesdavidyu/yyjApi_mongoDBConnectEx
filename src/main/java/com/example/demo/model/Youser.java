package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Yousers")
@AllArgsConstructor
@NoArgsConstructor
public class Youser {
    @Id
    private String id;
    private String email;
    private String password;
    private LocalDateTime createdAt;
}

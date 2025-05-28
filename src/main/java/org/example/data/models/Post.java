package org.example.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Post {
    private String id;
    private String emailAddress;
    private String title;
    private String description;
    private LocalDateTime createdAt;
}

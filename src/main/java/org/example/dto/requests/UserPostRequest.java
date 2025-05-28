package org.example.dto.requests;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class UserPostRequest {
    private String emailAddress;
    private String title;
    private String description;
    private LocalDateTime createdAt;
}

package org.example.dto.requests;

import lombok.Data;
import org.example.data.models.User;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserPostRequest {
    private User user;
    private String title;
    private String description;
}

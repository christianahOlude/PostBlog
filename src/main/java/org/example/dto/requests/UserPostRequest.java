package org.example.dto.requests;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserPostRequest {
    private String id;
    private String email;
    private String title;
    private String description;
}

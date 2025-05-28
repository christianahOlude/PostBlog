package org.example.dto.responses;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document
public class UserPostResponse {
    private String emailAddress;
    private LocalDateTime createdAt;
    private String message;
}

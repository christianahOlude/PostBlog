package org.example.dto.responses;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserRegistrationResponse {
    private String emailAddress;
    private String message;
}
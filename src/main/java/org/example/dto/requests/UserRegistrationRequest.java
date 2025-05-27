package org.example.dto.requests;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserRegistrationRequest {
    private String name;
    private String password;
    @Indexed(unique = true)
    private String emailAddress;
}

package org.example.dto.responses;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserLoginResponse {
    @Indexed(unique = true)
    private String emailAddress;
    private String message;
}

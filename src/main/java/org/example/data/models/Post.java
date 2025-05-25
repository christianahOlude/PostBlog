package org.example.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Post {
    private String id;
    private String title;
    private String description;
}

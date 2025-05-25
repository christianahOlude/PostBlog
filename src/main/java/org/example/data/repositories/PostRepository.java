package org.example.data.repositories;

import org.example.data.models.Post;
import org.example.dto.responses.UserPostResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}

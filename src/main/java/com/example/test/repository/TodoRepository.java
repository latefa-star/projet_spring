package com.example.test.repository;

import com.example.test.entities.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    public Todo findByTitle(String title);
}

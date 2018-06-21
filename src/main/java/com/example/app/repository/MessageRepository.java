package com.example.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.app.model.Message;

public interface MessageRepository extends MongoRepository<Message,String> {
    List<Message> findAll();
}

package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Message;
import com.example.app.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	MessageRepository messageRepository;

	public void save(Message message) {
		messageRepository.save(message);
	}
	
	public List<Message> findAll(Message message) {
		return messageRepository.findAll();
	}

}

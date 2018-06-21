package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Message;
import com.example.app.repository.MessageRepository;
import com.example.app.service.MessageService;

@RestController
public class controller {

	@Autowired
	MessageService messageService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Message message) {
		messageService.save(message);
	}

	@RequestMapping("/messages")
	public List<Message> listAllMessages(Message message) {
		return messageService.findAll(message);
	}
}

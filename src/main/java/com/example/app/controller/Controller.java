package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.example.app.model.Message;
import com.example.app.service.MessageService;

@RestController
public class Controller {

	@Autowired
	MessageService messageService;

	@Autowired
	private SimpMessagingTemplate template;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Message message) {
		messageService.save(message);
		template.convertAndSend("/topic/message", HtmlUtils.htmlEscape(message.getMessage().toString()));
	}

	@RequestMapping("/messages")
	public List<Message> listAllMessages() {
		return messageService.findAll();
	}

}

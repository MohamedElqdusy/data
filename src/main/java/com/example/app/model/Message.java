package com.example.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
public class Message {

	String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

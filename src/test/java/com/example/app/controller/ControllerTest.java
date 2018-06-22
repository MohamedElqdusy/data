package com.example.app.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.app.model.Message;
import com.example.app.service.MessageService;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
@ComponentScan("com.example.app.config")
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MessageService messageService;

	@Test
	public void testListAllMessages() throws Exception {

		List<Message> messagesList = Arrays.asList(new Message("message1"), new Message("message2"));
		Mockito.when(messageService.findAll()).thenReturn(messagesList);

		this.mockMvc.perform(get("/messages").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().string(containsString("message1")))
				.andExpect(content().string(containsString("message")));

	}

	@Test
	public void testAdd() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/add")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content("\"message250\"");
		this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
package com.hollywood.fast.sampleapp.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hollywood.fast.sampleapp.spring.service.MessageService;

@Controller
@RequestMapping("message")
public class MessageController {

	private final Logger log = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("hello")
	public final String hello(final ModelMap model) {
		log.debug("Running hello");
		model.addAttribute("message", messageService.getMessage());
		// return the name of the view
		return "hello";
	}
	
}

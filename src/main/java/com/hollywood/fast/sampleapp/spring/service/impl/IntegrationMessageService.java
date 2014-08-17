package com.hollywood.fast.sampleapp.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hollywood.fast.sampleapp.spring.service.MessageService;

public class IntegrationMessageService implements MessageService {

  private final Logger log = LoggerFactory.getLogger(IntegrationMessageService.class);
  
  public IntegrationMessageService() {
    log.debug("Setting up intergation message service");
  }

  public String getMessage() {
    return "Hello from integration message service";
  }

}

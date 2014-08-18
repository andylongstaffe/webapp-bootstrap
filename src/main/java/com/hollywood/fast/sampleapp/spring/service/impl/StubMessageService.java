package com.hollywood.fast.sampleapp.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hollywood.fast.sampleapp.spring.service.MessageService;

public class StubMessageService implements MessageService {

  private final Logger log = LoggerFactory.getLogger(StubMessageService.class);
  
  public StubMessageService() {
    log.debug("Setting up stub message service");
  }

  public String getMessage() {
    return "Hello from the stub message service";
  }

}

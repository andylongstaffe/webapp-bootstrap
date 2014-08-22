package com.hollywood.fast.sampleapp.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hollywood.fast.sampleapp.spring.service.MessageService;

public class RealMessageService implements MessageService {

  private final Logger log = LoggerFactory.getLogger(RealMessageService.class);
  private String url;
  
  public RealMessageService(String restUrl) {
    url = restUrl;
    log.debug("Setting up real message service at " + restUrl);
  }

  public String getMessage() {
    return "Hello from integration message service pointing at " + url;
  }

} 

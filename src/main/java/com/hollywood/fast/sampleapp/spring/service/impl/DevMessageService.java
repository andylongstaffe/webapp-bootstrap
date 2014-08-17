package com.hollywood.fast.sampleapp.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hollywood.fast.sampleapp.spring.controller.SampleController;
import com.hollywood.fast.sampleapp.spring.service.MessageService;

public class DevMessageService implements MessageService {

  private final Logger log = LoggerFactory.getLogger(DevMessageService.class);
  
  public DevMessageService() {
    log.debug("Setting up development message service");
  }
  
  @Override
  public String getMessage() {
    return "Hello from the development message service";
  }

}

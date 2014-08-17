package com.hollywood.fast.sampleapp.configuration;

import com.hollywood.fast.sampleapp.spring.service.MessageService;


public interface MessageServiceConfig {

  MessageService messageService();
  
}
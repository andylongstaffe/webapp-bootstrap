package com.hollywood.fast.sampleapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hollywood.fast.sampleapp.spring.service.MessageService;
import com.hollywood.fast.sampleapp.spring.service.impl.DevMessageService;

@Configuration
@Profile("dev")
public class DevMessageServiceConfig implements MessageServiceConfig {

  @Bean
  public MessageService messageService() {
    return new DevMessageService();
  }

}

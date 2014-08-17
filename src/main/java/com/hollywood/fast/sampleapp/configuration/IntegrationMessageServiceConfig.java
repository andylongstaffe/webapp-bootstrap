package com.hollywood.fast.sampleapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hollywood.fast.sampleapp.spring.service.MessageService;
import com.hollywood.fast.sampleapp.spring.service.impl.IntegrationMessageService;

@Configuration
@Profile("integration")
public class IntegrationMessageServiceConfig implements MessageServiceConfig {

  @Bean
  public MessageService messageService() {
    return new IntegrationMessageService();
  }

}

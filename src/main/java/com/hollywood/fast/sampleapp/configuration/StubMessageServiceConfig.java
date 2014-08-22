package com.hollywood.fast.sampleapp.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hollywood.fast.commons.configuration.impl.DefaultFastConfiguration;
import com.hollywood.fast.sampleapp.spring.service.MessageService;
import com.hollywood.fast.sampleapp.spring.service.impl.RealMessageService;
import com.hollywood.fast.sampleapp.spring.service.impl.StubMessageService;

@Configuration
@Profile("dev")
public class StubMessageServiceConfig {

  private static final Logger logger = LoggerFactory.getLogger(StubMessageServiceConfig.class);
  
  @Autowired
  DefaultFastConfiguration mainConfig;
  
  @Bean
  MessageService messageService() throws ConfigurationException {    
    logger.debug("StubMessageServiceConfig : creating stub message service bean");  
    return new StubMessageService();
  }
  
  public StubMessageServiceConfig() {
    logger.debug("Constructor for " + this.getClass().getSimpleName());  
  }
  
}

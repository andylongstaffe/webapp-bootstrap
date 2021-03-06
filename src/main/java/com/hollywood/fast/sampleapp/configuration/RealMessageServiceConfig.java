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

@Configuration
@Profile("integration")

public class RealMessageServiceConfig {

  private static final Logger logger = LoggerFactory.getLogger(RealMessageServiceConfig.class);
  
  @Autowired
  DefaultFastConfiguration mainConfig;
  
  @Bean
  MessageService messageService() throws ConfigurationException {    
    logger.debug("RealMessageServiceConfig : creating real message service bean");  
    String restUrl = mainConfig.getConfig().getString("app.sample.property");
      return new RealMessageService(restUrl);
  }
  
  public RealMessageServiceConfig() {
    logger.debug("Constructor for RealMessageServiceConfig");  
  }
  
}

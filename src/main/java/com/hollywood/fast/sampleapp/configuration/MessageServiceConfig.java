package com.hollywood.fast.sampleapp.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hollywood.fast.commons.configuration.impl.DefaultFastConfiguration;
import com.hollywood.fast.sampleapp.spring.service.MessageService;
import com.hollywood.fast.sampleapp.spring.service.impl.RealMessageService;
import com.hollywood.fast.sampleapp.spring.service.impl.StubMessageService;

@Configuration
public class MessageServiceConfig {

  private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
  
  @Autowired DefaultFastConfiguration mainConfig;
  
  @Bean
  MessageService messageService() throws ConfigurationException {
    String envType = mainConfig.getCurrentEnv();
    logger.debug("messageService bean envtype is " + envType);
    if ( "dev".equals(envType) ) {
      return new StubMessageService();
    }
    else {
      String restUrl = mainConfig.getConfig().getString("app.sample.property");
      return new RealMessageService(restUrl);
    }
  }
  
}
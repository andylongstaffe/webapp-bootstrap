package com.hollywood.fast.sampleapp.configuration;


import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.hollywood.fast.commons.BuildInformation;
import com.hollywood.fast.commons.configuration.impl.DefaultFastConfiguration;

@Configuration
@Import(MvcConfig.class)
public class AppConfig {

  private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
   
  @Bean
  DefaultFastConfiguration mainConfig() throws ConfigurationException {
    logger.debug("setting up main configuration");
    return new DefaultFastConfiguration("main.properties");
  } 
  
  @Bean
  BuildInformation buildInfo() {
    logger.debug("setting up build information");
    return new BuildInformation();
  }
  
  public AppConfig() throws ConfigurationException {
    logger.debug("Loading AppConfig");
  }    

}

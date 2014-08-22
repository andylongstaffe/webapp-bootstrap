package com.hollywood.fast.sampleapp.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.AbstractEnvironment;

import com.hollywood.fast.sampleapp.spring.controller.SampleController;

public class ActiveProfileConfiguration implements ServletContextListener {

  private final Logger log = LoggerFactory.getLogger(ActiveProfileConfiguration.class);
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.debug("Setting active spring profile");
    String profile;
    if ( System.getenv("envtype") != null ) {
      profile = System.getenv("envtype");
    }
    else if (System.getProperty("envtype") != null ) {
      profile = System.getProperty("envtype");
    }
    else {
      throw new IllegalStateException("No envtype found.");
    }
    System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, profile);
    log.info("Spring profile set to " + profile);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // TODO Auto-generated method stub

  }

}

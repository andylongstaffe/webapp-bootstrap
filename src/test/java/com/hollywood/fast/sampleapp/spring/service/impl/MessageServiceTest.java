package com.hollywood.fast.sampleapp.spring.service.impl;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.hollywood.fast.commons.configuration.impl.DefaultFastConfiguration;
import com.hollywood.fast.sampleapp.configuration.AppConfig;
import com.hollywood.fast.sampleapp.configuration.RealMessageServiceConfig;
import com.hollywood.fast.sampleapp.configuration.StubMessageServiceConfig;
import com.hollywood.fast.sampleapp.spring.service.MessageService;

public class MessageServiceTest {

  private CucumberConfiguration config;
  
  private class CucumberConfiguration extends DefaultFastConfiguration {

    public CucumberConfiguration(String configFilename)
        throws ConfigurationException {
      super(configFilename);
      // TODO Auto-generated constructor stub
    }
   
  }
  
  @Before
  public void before() throws Exception {
    
  }  
  
  //@Test
  public void testIntegration() throws Exception {
    String expectedMessage = "Hello from integration message service";
    System.setProperty("envtype", "integration");    
    config = new CucumberConfiguration("testing.properties");
    
    String envtype = config.getCurrentEnv();
    
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.getEnvironment().setActiveProfiles(envtype);
    ctx.register(AppConfig.class);
    // ctx.scan("com.hollywood.fast.sampleapp.configuration");
    ctx.refresh();

    MessageService activeMessageService = ctx.getBean(MessageService.class);
    Assert.assertEquals(expectedMessage, activeMessageService.getMessage());
  }
  
  //@Test
  public void testDev() throws Exception {
    String expectedMessage = "Hello from the development message service";
    System.setProperty("envtype", "dev");  
    System.setProperty("spring.profiles.active", "dev");    
    config = new CucumberConfiguration("testing.properties");
    
    String envtype = config.getCurrentEnv();
    
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.getEnvironment().setActiveProfiles(envtype);
    ctx.register(AppConfig.class);
    ctx.register(RealMessageServiceConfig.class);
    ctx.register(StubMessageServiceConfig.class);
    // ctx.scan("com.hollywood.fast.sampleapp.configuration");
    ctx.refresh();

    MessageService activeMessageService = ctx.getBean(MessageService.class);
    Assert.assertEquals(expectedMessage, activeMessageService.getMessage());
  }
  


}

package com.hollywood.fast.sampleapp.spring.service.impl;

import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.hollywood.fast.sampleapp.configuration.AppConfig;
import com.hollywood.fast.sampleapp.configuration.DevMessageServiceConfig;
import com.hollywood.fast.sampleapp.configuration.IntegrationMessageServiceConfig;
import com.hollywood.fast.sampleapp.spring.service.MessageService;

public class MessageServiceTest {

  @Test
  public void test() {   
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.getEnvironment().setActiveProfiles("integration");
    ctx.register(DevMessageServiceConfig.class);
    ctx.register(IntegrationMessageServiceConfig.class);
    // ctx.scan("com.hollywood.fast.sampleapp.configuration");
    ctx.refresh();

    MessageService activeMessageService = ctx.getBean(MessageService.class);
    System.out.println(activeMessageService.getMessage());
  }
  


}

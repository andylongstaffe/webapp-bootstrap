package com.hollywood.fast.sampleapp.configuration;


import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hollywood.fast.sampleapp.spring.service.MessageService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.hollywood.fast.sampleapp" })
public class AppConfig extends WebMvcConfigurerAdapter {

  private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
  
  //@Autowired
  MessageService messageService;
  private MessageServiceConfig messageServiceConfig;
  
  public AppConfig() {
    logger.debug("Loading AppConfig");
  }  
  
  @Bean
  public InternalResourceViewResolver viewResolver() {
    logger.debug("set up view resolver");
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/view/");
    resolver.setSuffix(".jsp");
    return resolver;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    logger.debug("setting up resource handlers");
    registry.addResourceHandler("/resources/**").addResourceLocations("/res/");
  }

  @Override
  public void configureDefaultServletHandling(

  DefaultServletHandlerConfigurer configurer) {
    logger.debug("configureDefaultServletHandling");
    configurer.enable();
  }

  @Bean
  public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
    SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();

    Properties mappings = new Properties();
    mappings.put("org.springframework.web.servlet.PageNotFound", "p404");
    mappings.put("org.springframework.dao.DataAccessException",
        "dataAccessFailure");
    mappings.put("org.springframework.transaction.TransactionException",
        "dataAccessFailure");
    b.setExceptionMappings(mappings);
    return b;
  }

  @Bean
  public LocalValidatorFactoryBean validator() {
    return new LocalValidatorFactoryBean();
  }

}

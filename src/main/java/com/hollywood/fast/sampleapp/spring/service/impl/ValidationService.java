package com.hollywood.fast.sampleapp.spring.service.impl;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollywood.fast.sampleapp.configuration.AppConfig;

@Service
public class ValidationService {

  private static final Logger logger = LoggerFactory.getLogger(ValidationService.class);
  
  public ValidationService() {
    logger.debug("Sample validator service setup");
  }
  
  @Autowired
  private Validator validator;

}

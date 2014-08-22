package com.hollywood.fast.sampleapp.spring.service.impl;

import org.junit.Test;

import com.hollywood.fast.sampleapp.spring.service.CountryService;

public class CountryServiceImplTest {

  CountryService service = new CountryServiceImpl();
  
  @Test
  public void testGetInfo() {
    System.out.println(service.getInfo("norway"));
  }

}

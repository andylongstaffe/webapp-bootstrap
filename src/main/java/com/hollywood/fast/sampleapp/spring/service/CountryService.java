package com.hollywood.fast.sampleapp.spring.service;

import com.hollywood.fast.sampleapp.spring.model.CountryInfo;

public interface CountryService {
   
  public CountryInfo getInfo(String countryName);
  
}

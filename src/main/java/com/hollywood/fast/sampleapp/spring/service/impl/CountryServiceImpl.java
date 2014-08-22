package com.hollywood.fast.sampleapp.spring.service.impl;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hollywood.fast.sampleapp.spring.model.CountryInfo;
import com.hollywood.fast.sampleapp.spring.service.CountryService;

public class CountryServiceImpl implements CountryService {

  String baseUrl="http://restcountries.eu/rest/v1/name/";
  
  @Override
  public CountryInfo getInfo(String countryName) {
    String url = baseUrl + countryName;
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
    List<CountryInfo> countries = getCountries(result.getBody());
    return countries.get(0);
  }

  private List<CountryInfo> getCountries(String countryList) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    List<CountryInfo> countryInfoList =  null;
    try {
      countryInfoList = mapper.readValue(countryList, mapper.getTypeFactory().constructCollectionType(List.class, CountryInfo.class));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return countryInfoList;
  }

}

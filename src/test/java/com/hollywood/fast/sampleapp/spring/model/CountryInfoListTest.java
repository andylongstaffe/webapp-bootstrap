package com.hollywood.fast.sampleapp.spring.model;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class CountryInfoListTest {

  private String norwayInfo = "[{\"name\": \"Norway\",\"capital\": \"Oslo\",\"region\": \"Europe\"}]";
  
  @Test
  public void test() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    List<CountryInfo> countryInfoList = mapper.readValue(norwayInfo, mapper.getTypeFactory().constructCollectionType(List.class, CountryInfo.class));
    CountryInfo norway = countryInfoList.get(0);
    System.out.println(norway.getName());
    System.out.println(norway.getCapital());
    System.out.println(norway.getRegion());
  }

}

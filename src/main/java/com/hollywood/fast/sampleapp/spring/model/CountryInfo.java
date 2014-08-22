package com.hollywood.fast.sampleapp.spring.model;

public class CountryInfo {

  String name;
  String capital;
  String region;
  
  public String getName() {
    return name;
  }
  public String getCapital() {
    return capital;
  }
  public String getRegion() {
    return region;
  }
  @Override
  public String toString() {
    return "CountryInfo [name=" + name + ", capital=" + capital + ", region="
        + region + "]";
  }
  
}

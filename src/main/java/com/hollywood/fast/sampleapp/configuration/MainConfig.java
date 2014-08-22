package com.hollywood.fast.sampleapp.configuration;

import java.util.Set;

import org.apache.commons.configuration.Configuration;
import org.springframework.stereotype.Component;

import com.hollywood.fast.commons.configuration.FastConfiguration;
import com.hollywood.fast.commons.configuration.impl.DefaultFastConfiguration;

@Component
public class MainConfig implements FastConfiguration {

  DefaultFastConfiguration cfg;
  
  @Override
  public Set<String> addEnvType(String envType) {
    return cfg.addEnvType(envType);
  }

  @Override
  public Set<String> setEnvTypes(Set<String> envTypes) {
    return cfg.setEnvTypes(envTypes);
  }

  @Override
  public Configuration getConfig() {
    return cfg.getConfig();
  }

  @Override
  public String getCurrentEnv() {
    return cfg.getCurrentEnv();
  }

 
}

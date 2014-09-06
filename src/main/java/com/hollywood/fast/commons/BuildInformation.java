package com.hollywood.fast.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;

public class BuildInformation implements ServletContextAware {

  private final Logger log = LoggerFactory.getLogger(BuildInformation.class);
  
  private ServletContext servletContext;
  private boolean firstAccess = true;
  private String versionNumber = "not set";
  private String manifest = "META-INF/MANIFEST.MF";
  private String IMPLEMENTATION_VERSION = "Implementation-Version";
  
  public String getVersion() {
    if ( firstAccess ) {
      // load build info
      getBuildInfo();
    }
    return versionNumber;
  }
  
  private void getBuildInfo() {   
    log.debug("Loading build information");
    boolean errorReadingManifest = false;
    Properties props = new Properties();
    try {    
      InputStream is = servletContext.getResourceAsStream(manifest);
      if ( is != null ) {
        props.load(is);
        versionNumber = (String) props.getProperty(IMPLEMENTATION_VERSION );
      }
      else {
        log.error("Manifest not found at " + manifest);
        errorReadingManifest = true;
      }             
    } catch (IOException e) {
      errorReadingManifest = true;
      log.error("Error reading manifest at " + manifest, e);
    }    
    
    if ( errorReadingManifest ) {
      versionNumber = "1.0.0-1234";
    }
  }

  @Override
  public void setServletContext(ServletContext context) {
    this.servletContext = context;
  }

}

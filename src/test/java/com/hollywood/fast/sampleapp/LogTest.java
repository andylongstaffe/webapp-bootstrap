package com.hollywood.fast.sampleapp;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import com.hollywood.fast.commons.configuration.FastConfiguration;
import com.hollywood.fast.commons.configuration.impl.DefaultFastConfiguration;

public class LogTest {

	private final Logger log = LoggerFactory.getLogger(LogTest.class);
	
	@Test
	public void test() {
		
		log.error("Error event");
		log.warn("Warning event");
		log.info("Info event");
		log.debug("Debug event");
		log.trace("Trace event");
	}
	
	@Test
	public void springTest() throws Exception {
	    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	    ctx.register(TestConfig.class);
	    ctx.refresh();
	    TestBean bean = ctx.getBean(TestBean.class);
	    log.info("Test bean set up");
	    log.info(bean.getMessage());
	}
	
	@Test
	public void testConfig() throws Exception {
		logBackInternalStatus();
		FastConfiguration config = new DefaultFastConfiguration("testing.properties");	    
	    String envtype = config.getCurrentEnv();
	    log.info("Config env is " + envtype);
	}
	
	public void logBackInternalStatus() {
		 // assume SLF4J is bound to logback in the current environment
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    // print logback's internal status
	    StatusPrinter.print(lc);
	}

}

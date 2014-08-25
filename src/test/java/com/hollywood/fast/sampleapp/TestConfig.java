package com.hollywood.fast.sampleapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	@Bean
	TestBean testBean() {
		return new TestBean();
	}
	
}

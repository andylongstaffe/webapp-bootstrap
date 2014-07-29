package com.hollywood.fast.sampleapp.spring.service;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

	@Autowired
    private Validator validator;
	
}

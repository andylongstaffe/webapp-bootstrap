package com.hollywood.fast.sampleapp.spring.service;

import com.hollywood.fast.sampleapp.spring.model.Customer;

public interface CustomerService {
	
	void addCustomer(Customer customer);
	
	Customer getCustomer(String firstName);
	
}

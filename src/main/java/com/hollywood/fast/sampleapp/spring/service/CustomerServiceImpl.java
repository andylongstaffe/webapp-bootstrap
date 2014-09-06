package com.hollywood.fast.sampleapp.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hollywood.fast.sampleapp.spring.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	Map<String,Customer> customers;
	
	public CustomerServiceImpl() {
		customers = new HashMap<String,Customer>();
	}
	
	@Override
	public void addCustomer(Customer customer) {
		customers.put(customer.getFirstName(), customer);

	}

	@Override
	public Customer getCustomer(String firstName) {
		return customers.get(firstName);

	}

}

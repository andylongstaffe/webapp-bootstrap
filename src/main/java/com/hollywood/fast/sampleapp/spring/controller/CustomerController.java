package com.hollywood.fast.sampleapp.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hollywood.fast.commons.BuildInformation;
import com.hollywood.fast.sampleapp.spring.model.Customer;
import com.hollywood.fast.sampleapp.spring.model.ErrorMessage;
import com.hollywood.fast.sampleapp.spring.model.ValidationResponse;
import com.hollywood.fast.sampleapp.spring.service.CustomerService;
import com.hollywood.fast.sampleapp.spring.service.MessageService;
import com.hollywood.fast.sampleapp.spring.service.impl.ValidationService;

/**
 * Main controller for this project.
 * 
 * @author andy
 * 
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

	private final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ValidationService service;

	@Autowired
	private CustomerService customerService;

	public CustomerController() {
		log.debug("Creating customer controller");
	}
	
	/**
	 * Display blank customer form
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView newCustomer() {
		return new ModelAndView("customer", "customer", new Customer());
	}
	
	/**
	 * Display customer identified by firstName or blank customer form
	 * @return
	 */
	@RequestMapping(value = "{firstName}", method = RequestMethod.GET)
	public ModelAndView getCustomer(@PathVariable("firstName") String firstName) {
		Customer customer = customerService.getCustomer(firstName);
		if ( customer == null ) {
			customer = new Customer();
		}
		return new ModelAndView("customer", "customer", customer);
	}

	/**
	 * anything
	 * 
	 * @param model
	 * @param customer
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/customer.json", method = RequestMethod.POST)
	public @ResponseBody ValidationResponse processForm(Model model,
			@Valid Customer customer, BindingResult result) {
		ValidationResponse res = new ValidationResponse();
		if (!result.hasErrors()) {
			res.setStatus("SUCCESS");
		} else {
			res.setStatus("FAIL");
			List<FieldError> allErrors = result.getFieldErrors();
			List<ErrorMessage> errorMesages = new ArrayList<ErrorMessage>();
			for (FieldError objectError : allErrors) {
				errorMesages.add(new ErrorMessage(objectError.getField(),
						objectError.getField() + "  "
								+ objectError.getDefaultMessage()));
			}
			res.setErrorMessageList(errorMesages);
		}
		// …
		return res;
	}

	/**
	 * Validates customer details and either returns user to form or displays
	 * valid customer in a jsp page
	 * 
	 * @param customer
	 * @param result
	 * @param m
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String addCustomer(@Valid Customer customer, BindingResult result,
			Model m) {

		if (result.hasErrors()) {
			return "customer";
		} else {
			customerService.addCustomer(customer);
			m.addAttribute("c", customer);
			return "result";
		}
	}


}

package uk.gov.ipo.fast.sampleapp.spring.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.gov.ipo.fast.sampleapp.spring.model.Customer;
import uk.gov.ipo.fast.sampleapp.spring.service.SampleService;

/**
 * Main controller for this project.
 * 
 * @author andy
 * 
 */
@Controller
public class SampleController {

	Logger log = Logger.getLogger(SampleController.class);
	
	@Autowired
	SampleService service;
	
	/**
   * The welcome page.
   * 
   * @param model
   * @return
   */
  @RequestMapping("hello")
  public String loadHomePage(ModelMap model) {
    log.info("INFO Running SampleController");
    log.debug("DEBUG  Running SampleController");
	model.addAttribute("message", "Spring 3 MVC Hello World");
    // return the name of the view
    return "hello";
  }
  
  @RequestMapping("form-demo")
  public String loadForm(ModelMap model) {
	  return "form-demo";
  }
  
  @RequestMapping(value = "customer", method = RequestMethod.GET)
  public ModelAndView customer() {
	  return new ModelAndView("customer", "customer", new Customer());
  }
  
  @RequestMapping(value = "addCustomer", method = RequestMethod.POST)
  public String addCustomer(@Valid Customer customer, BindingResult result, Model m)
  {
	  
	  
	  if ( result.hasErrors() )
	  {
		  log.info(result);
		  return "customer";
	  }
	  else
	  {
		  m.addAttribute("c", customer);
		  return "result";
	  }  
  }
  
  @RequestMapping("test")
  public String testPage(ModelMap model) {
	  return "test";
  }
}

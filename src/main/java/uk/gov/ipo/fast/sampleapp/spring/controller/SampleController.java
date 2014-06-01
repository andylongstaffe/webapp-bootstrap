package uk.gov.ipo.fast.sampleapp.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.gov.ipo.fast.sampleapp.spring.model.Customer;

/**
 * Main controller for this project.
 * 
 * @author andy
 * 
 */
@Controller
public class SampleController {

	Logger log = Logger.getLogger(SampleController.class);
	
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
	  return new ModelAndView("customer", "command", new Customer());
  }
  
  @RequestMapping(value = "addCustomer", method = RequestMethod.POST)
  public String addCustomer(@ModelAttribute("SpringWeb") Customer customer, ModelMap model)
  {
	  model.addAttribute("c", customer);
	  return "result";
  }
  
  @RequestMapping("test")
  public String testPage(ModelMap model) {
	  return "test";
  }
}

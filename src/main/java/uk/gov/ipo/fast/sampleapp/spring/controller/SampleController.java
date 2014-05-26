package uk.gov.ipo.fast.sampleapp.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
  
}

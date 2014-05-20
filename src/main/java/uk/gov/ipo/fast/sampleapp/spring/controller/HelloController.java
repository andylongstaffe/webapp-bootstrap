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
public class HelloController {

	Logger log = Logger.getLogger(HelloController.class);
	
	/**
   * The welcome page.
   * 
   * @param model
   * @return
   */
  @RequestMapping("hello")
  public String loadHomePage(ModelMap model) {
    log.info("INFO Running HelloController");
    log.debug("DEBUG  Running HelloController");
	model.addAttribute("message", "Spring 3 MVC Hello World");
    // return the name of the view
    return "hello";
  }
}

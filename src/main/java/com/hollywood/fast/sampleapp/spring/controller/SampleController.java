package com.hollywood.fast.sampleapp.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hollywood.fast.sampleapp.spring.model.Customer;
import com.hollywood.fast.sampleapp.spring.model.ErrorMessage;
import com.hollywood.fast.sampleapp.spring.service.SampleService;

/**
 * Main controller for this project.
 * 
 * @author andy
 * 
 */
@Controller
public class SampleController {

  /**
   * 
   */
  private final Logger log = Logger.getLogger(SampleController.class);
  /**
   * 
   */
  @Autowired
  private SampleService service;



  @RequestMapping("hello")
  public final String loadHomePage(final ModelMap model) {
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

  /**
   * anything
   * @param model
   * @param customer
   * @param result
   * @return
   */
  @RequestMapping(value = "/customer.json", method = RequestMethod.POST)
  public @ResponseBody
  ValidationResponse processForm(Model model, @Valid Customer customer,
      BindingResult result) {
    ValidationResponse res = new ValidationResponse();
    if (!result.hasErrors()) {
      res.setStatus("SUCCESS");
    } else {
      res.setStatus("FAIL");
      List<FieldError> allErrors = result.getFieldErrors();
      List<ErrorMessage> errorMesages = new ArrayList<ErrorMessage>();
      for (FieldError objectError : allErrors) {
        errorMesages.add(new ErrorMessage(objectError.getField(), objectError
            .getField() + "  " + objectError.getDefaultMessage()));
      }
      res.setErrorMessageList(errorMesages);
    }
    // …
    return res;
  }

  @RequestMapping(value = "addCustomer", method = RequestMethod.POST)
  public String addCustomer(@Valid Customer customer, BindingResult result,
      Model m) {


    if (result.hasErrors()) {
      log.info(result);
      return "customer";
    } else {
      m.addAttribute("c", customer);
      return "result";
    }
  }

  @RequestMapping("test")
  public String testPage(ModelMap model) {
    return "test";
  }
}

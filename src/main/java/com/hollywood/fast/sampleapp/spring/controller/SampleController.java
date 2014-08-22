package com.hollywood.fast.sampleapp.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hollywood.fast.commons.BuildInformation;
import com.hollywood.fast.sampleapp.spring.model.Customer;
import com.hollywood.fast.sampleapp.spring.model.ErrorMessage;
import com.hollywood.fast.sampleapp.spring.service.MessageService;
import com.hollywood.fast.sampleapp.spring.service.impl.ValidationService;

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
  private final Logger log = LoggerFactory.getLogger(SampleController.class);
  /**
   * 
   */
  @Autowired
  private ValidationService service;
  
  @Autowired
  private MessageService messageService;
  
  @Autowired
  private BuildInformation buildInfo;

  public SampleController() {
    log.debug("Creating sample controller");
  }
  
  @RequestMapping("hello")
  public final String hello(final ModelMap model) {
    log.debug("Running hello");
    model.addAttribute("message", messageService.getMessage());
    // return the name of the view
    return "hello";
  }

  @RequestMapping("version")
  public final String version(final ModelMap model) {
    log.debug("Running version");
    model.addAttribute("applicationName", getAppName());
    model.addAttribute("versionNumber", getVersionNumber());
    // return the name of the view
    return "version";
  }

  private Object getAppName() {
    return "default name";
  }

  private String getVersionNumber() {
    return buildInfo.getVersion();
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
   * 
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
      // log.info(result);
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

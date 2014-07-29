package com.hollywood.fast.sampleapp;

import java.util.List;
import java.util.Map;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormInputSteps {
  
  @Given("^I have logged into the application$")
  public void i_have_logged_into_the_application() throws Throwable {
      System.out.println("I am logged in");
  }
  
  @Given("^I have loaded form \"(.*?)\"$")
  public void i_have_loaded_form(String formName) throws Throwable {
    System.out.println("When step for form " + formName);
  }
  
  
  @When("^I input the following details into the form:$")
  public void i_input_the_following_details_into_the_form(List<Map<String,String>> inputFieldValues) throws Throwable {
      System.out.println("Input provided:");
      for ( Map<String, String> fieldValuePair : inputFieldValues) {
        System.out.println(fieldValuePair.toString());
      }
  }
  
  @Then("^i should be able to see \"(.*?)\"$")
  public void i_should_be_able_to_see(String expectedOutput) throws Throwable {
      System.out.println("I can see " + expectedOutput);
  }
  
  @Given("^i have been given the following information$")
  public void i_have_been_given_the_following_information(String text) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      System.out.println("doc string: " + text);
  }

  @When("^i do something$")
  public void i_do_something() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      System.out.println("TODO check something");
  }

  @Then("^i see something else$")
  public void i_see_something_else() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
    System.out.println("TODO check something");
  }
}

package com.hollywood.fast.sampleapp.website;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebsiteInputSteps {
  
  private WebDriver driver;
  
  @Before
  public void before() {
    // driver = new FirefoxDriver();
    
    class CustomHtmlUnitDriver extends HtmlUnitDriver {
      public WebClient getWebClient() {
        return super.getWebClient();
      }
    }
    CustomHtmlUnitDriver htmlUnitDriver = new CustomHtmlUnitDriver();
    htmlUnitDriver.getWebClient().setCssErrorHandler(new SilentCssErrorHandler());
    
    driver = htmlUnitDriver;

    
  }
  
  @Given("^i am on the bbc weather page$")
  public void i_am_on_the_bbc_weather_page() throws Throwable {
    driver.get("http://www.bbc.co.uk/weather");
  }

  @When("^i enter \"(.*?)\" into the search box and click search$")
  public void i_enter_into_the_search_box_and_click_search(String location) throws Throwable {
    driver.findElement(By.id("locator-form-search")).sendKeys(location);
    driver.findElement(By.id("locator-form-submit")).click();
  }

  @Then("^the weather forecase for \"(.*?)\" is displayed$")
  public void the_weather_forecase_for_is_displayed(String location) throws Throwable {
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    String text = driver.findElement(By.className("location-name")).getText();
    
    System.out.println(text);
  }
  
 
}

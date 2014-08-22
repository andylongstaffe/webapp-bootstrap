package com.hollywood.fast.sampleapp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty", "html:target/cucumber"}, monochrome=true, tags={"@fixtures", "~@ignore","~@wip"})
public class RunTests {
}

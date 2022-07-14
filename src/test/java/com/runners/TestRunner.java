package com.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/SuccessfulLoginTest.feature","src/test/resources/features/FailedLoginTest.feature"},
        glue = {"com.stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty", "html:target/cucumber-reports",
        		  "json:target/cucumber.json"},
        tags={"@UI","@Prod"},
		monochrome = true
)

public class TestRunner {
	
}
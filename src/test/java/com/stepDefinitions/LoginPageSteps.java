package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.custombdd.pages.LoginPage;
import pages.custombdd.pages.WebDriverManager;

public class LoginPageSteps {
	
	public WebDriver driver;
	public WebDriverManager webDriverManager;
	public LoginPage loginPage;

	@Before("@UI")
	public void before() throws Throwable {
		webDriverManager = new WebDriverManager();
		String browserName = "chrome";
		driver = webDriverManager.getDriver(browserName);
	}

	@After("@UI")
	public void after(Scenario scenario) throws Throwable {
		webDriverManager.closeDriver(scenario);
	}

	@Given("I Launch Application with {string} as URL in Browser")
	public void launch_ApplicationURLInBrowser(String value) throws Throwable {
		driver.get(value);
	}
	
	@Then("I Verify Login Page Loaded Successfully")
	public void verify_LoginPage() throws Throwable {
		loginPage = new LoginPage(driver);
		boolean result = loginPage.verifyLoginPage();
		Assert.assertTrue("Problem in Loading Application Login Page.", result);
	}
	
    @When("I Enter {string} in Username Field; in Login Page")
    public void set_UserName(String userName) throws InterruptedException {
    	loginPage = new LoginPage(driver);
        loginPage.set_UserName(userName);
    }
    
    @When("I Enter {string} in Password Field; in Login Page")
    public void set_Password(String password) throws InterruptedException {
    	loginPage = new LoginPage(driver);
    	loginPage.set_Password(password);
    }
    
    @When("I Click On Login Button; in Login Page")
    public void click_LoginButton() {
    	loginPage = new LoginPage(driver);
    	loginPage.clickLoginBtn();
    }
    
	@Then("I Verify Error Message Displayed for Locked out Credentials Successfully")
	public void verify_ErrorMessageForFailedLogins() throws Throwable {
		loginPage = new LoginPage(driver);
		boolean result = loginPage.verifyErrorPage();
		Assert.assertTrue("Problem in Loading Error Message in Application Login Page.", result);
	}
    
}
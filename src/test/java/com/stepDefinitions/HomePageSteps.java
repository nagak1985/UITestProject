package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.custombdd.pages.HomePage;
import pages.custombdd.pages.WebDriverManager;

public class HomePageSteps {
	
	public WebDriver driver = getDriver();
	public HomePage homePage;
	
	public WebDriver getDriver() {
		return WebDriverManager.driver;
	}
    
	@Then("I Verify Home Page Loaded Successfully")
	public void verify_ApplicationHomePage() throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue("Problem in Loading Application Home Page.", result);
	}
	
	@Then("I Verify Application Logo displayed Succesfully")
	public void verify_ApplicationLogoInHomePage() throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue("Problem in Loading Application Home Page.", result);
	}
	
    @When("I Click On Menu Button; in Home Page")
    public void click_MenuButton() {
    	homePage = new HomePage(driver);
    	homePage.clickMenuBtn();
    }
    
    @When("I Click On Logout Button; in Home Page")
    public void click_LogoutButton() {
    	homePage = new HomePage(driver);
    	homePage.clickLogoutBtn();
    }

}
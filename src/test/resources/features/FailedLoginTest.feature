Feature: Swag Labs - Failed Login Test Feature

@UI
Scenario Outline: Verify Banned User Unable To Login with Locked Credentials
	Given I Launch Application with "<url>" as URL in Browser
	Then I Verify Login Page Loaded Successfully
	When I Enter "<username>" in Username Field; in Login Page
	When I Enter "<password>" in Password Field; in Login Page
	When I Click On Login Button; in Login Page
  Then I Verify Error Message Displayed for Locked out Credentials Successfully

@Prod
Examples: 
  | url                        | username        | password     |
  | https://www.saucedemo.com  | locked_out_user | secret_sauce |
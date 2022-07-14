Feature: Swag Labs - Successfuly Login Test

@UI
Scenario Outline: Verify swag Labs Customer/User Able To Login to Application Successfully
	Given I Launch Application with "<url>" as URL in Browser
	Then I Verify Login Page Loaded Successfully
	When I Enter "<username>" in Username Field; in Login Page
	When I Enter "<password>" in Password Field; in Login Page
	When I Click On Login Button; in Login Page
	Then I Verify Home Page Loaded Successfully
	Then I Verify Application Logo displayed Succesfully

@Prod
Examples: 
  | url                       | username      | password     |
  | https://www.saucedemo.com | standard_user | secret_sauce |
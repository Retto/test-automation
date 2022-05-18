@login
Feature: login Page
  In order to test login page
  As a Registered user
  I want to specify the login conditions   

	Scenario: Login Page
    Given user is on landing page
    And Sign in button is present on screen
    When user enters "kobiz.technology@gmail.com" in username field
    And user enters "retto-test" in password field
    And user clicks Sign in button
    Then title of page is "ThingsBoard Demo | Home"

     
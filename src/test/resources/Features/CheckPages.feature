@check-pages
Feature: Check pages
     
	Background:
    Given user move to home page
    
  Scenario: Login Page
    Given user is on landing page
    And Sign in button is present on screen
    When user enters "kobiz.technology@gmail.com" in username field
    And user enters "retto-test" in password field
    And user clicks Sign in button
    Then title of page is "ThingsBoard Demo | Home"
    
	Scenario Outline: Check Specific Page
    Given user is logged
    When user clicks <menu> link
    Then title of page is <menu_title>
    And items are listed
    
    Examples:
			| menu             | menu_title                         |  
      | "Rule chains"    | "ThingsBoard Demo \| Rule chains"  |
      | "Customers"      | "ThingsBoard Demo \| Customers"    |
      | "Assets"         | "ThingsBoard Demo \| Assets"       |
      | "Devices"        | "ThingsBoard Demo \| Devices"      |